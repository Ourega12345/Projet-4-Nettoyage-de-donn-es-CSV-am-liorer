import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class App {
    public static void main(String[] args) {
        GestionnaireFichier gf = new GestionnaireFichier();
        NettoyeurDonnees nettoyeur = new NettoyeurDonnees();

        // Étape 1 : Choisir le fichier
        String cheminEntree = gf.demanderCheminFichier();

        if (cheminEntree != null) {
            // Étape 2 : Lire
            List<String> lignesBrutes = gf.lireCSV(cheminEntree);
            List<String> lignesNettoyees = new ArrayList<>();

            // Étape 3 : Nettoyer chaque ligne
            for (String ligne : lignesBrutes) {
                String[] cellules = ligne.split(",");
                StringBuilder ligneTraitee = new StringBuilder();

                for (int i = 0; i < cellules.length; i++) {
                    ligneTraitee.append(nettoyeur.traiterCellule(cellules[i]));
                    if (i < cellules.length - 1) ligneTraitee.append(",");
                }
                lignesNettoyees.add(ligneTraitee.toString());
            }

            // Étape 4 : Sauvegarder (Ici en ajoutant "_clean" au nom)
            File fichierEntree = new File(cheminEntree);
String nom = fichierEntree.getName();
String dossier = fichierEntree.getParent();

// Enlever l'extension
int index = nom.lastIndexOf(".");
String nomSansExtension = (index > 0) ? nom.substring(0, index) : nom;

// Nouveau nom
String nouveauNom = nomSansExtension + "_nettoye.csv";

// Nouveau chemin
String cheminSortie = dossier + File.separator + nouveauNom;

// Sauvegarde
gf.sauvegarderCSV(cheminSortie, lignesNettoyees);
        } else {
            System.out.println("Opération annulée.");
        }
    }
}
