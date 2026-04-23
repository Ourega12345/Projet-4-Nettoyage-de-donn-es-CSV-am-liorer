import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestionnaireFichier {

    public String demanderCheminFichier() {
        JFileChooser explorateur = new JFileChooser();
        explorateur.setDialogTitle("Sélectionnez le fichier CSV à nettoyer");

        FileNameExtensionFilter filtre = new FileNameExtensionFilter("Fichiers CSV", "csv");
        explorateur.setFileFilter(filtre);

        int resultat = explorateur.showOpenDialog(null);

        //  correction ici (une seule accolade)
        if (resultat == JFileChooser.APPROVE_OPTION) {
            File fichier = explorateur.getSelectedFile();
            return fichier.getAbsolutePath();
        }

        return null; // Si l'utilisateur annule
    }

    public List<String> lireCSV(String chemin) {
        List<String> lignes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(chemin))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                lignes.add(ligne);
            }
        } catch (IOException e) {
            System.err.println("Erreur de lecture : " + e.getMessage());
        }

        return lignes;
    }

    public void sauvegarderCSV(String chemin, List<String> donnees) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(chemin))) {
            for (String l : donnees) {
                pw.println(l);
            }
            System.out.println("Fichier sauvegardé : " + chemin);
        } catch (IOException e) {
            System.err.println("Erreur de sauvegarde : " + e.getMessage());
        }
    }
}