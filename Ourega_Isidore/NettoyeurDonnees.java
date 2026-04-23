public class NettoyeurDonnees {

    public String traiterCellule(String texte) {
        // 1. Gérer les valeurs manquantes
        if (texte == null || texte.trim().isEmpty()) {
            return null;
        }
        // 2. Standardiser (Majuscules)
        return texte.trim().toUpperCase();
    }
}
