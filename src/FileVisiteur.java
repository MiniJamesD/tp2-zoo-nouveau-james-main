public class FileVisiteur {
    private int nbElement;
    private NoeudVisiteur premier;
    private NoeudVisiteur dernier;
    public FileVisiteur() {
        nbElement = 0;
        premier = dernier = null;
    }
    public int getNbElements() {
        return nbElement;
    }
    public NoeudVisiteur getPremier() {
        return dernier;
    }
    public boolean contient(Visiteur valeur){
        for (NoeudVisiteur courant = premier; courant != null; courant = courant.getSuivant()) {
            if (courant.getValeur().equals(valeur)) {
                return true;
            }
        }
        return false;
    }
    public void ajouter(Visiteur valeur){
        if (nbElement == 0) {
            NoeudVisiteur courant = new NoeudVisiteur(valeur);
            courant.setSuivant(premier);
            premier = dernier = courant;
            nbElement++;
        }
        else {
            NoeudVisiteur courant = new NoeudVisiteur(valeur);
            courant.setSuivant(premier);
            premier = courant;
            nbElement++;
        }
    }
    public NoeudVisiteur retirer(){
        if (premier == null || premier.getSuivant() == null){
            if (premier == null)
                return null;

            premier = premier.getSuivant();
            --nbElement;
            return null;
        }
        NoeudVisiteur courant = premier;
        while (courant.getSuivant().getSuivant() != null)
            courant = courant.getSuivant();

        courant.setSuivant(null);
        --nbElement;
        return premier;
    }
    public String toString(){
        String str = " " + nbElement + " éléments: ";

        for (NoeudVisiteur courant = premier; courant != null; courant = courant.getSuivant()){
            str += courant;
        }
        return str;
    }
}
