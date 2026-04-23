import java.util.ArrayList;
import java.util.List;

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
            String cheminSortie = cheminEntree.replace(".csv", "_nettoye.csv");
            gf.sauvegarderCSV(cheminSortie, lignesNettoyees);
        } else {
            System.out.println("Opération annulée.");
        }
    }
}