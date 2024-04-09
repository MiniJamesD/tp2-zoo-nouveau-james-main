public class FileEnclos {
    private int nbElement;
    private NoeudEnclos premier;
    private NoeudEnclos dernier;

    public FileEnclos() {
        nbElement = 0;
        premier = dernier = null;
    }

    public int getNbElements() {
        return nbElement;
    }

    public NoeudEnclos getPremier() {
        return dernier;
    }


    public boolean contient(Enclos valeur){
        for (NoeudEnclos courant = premier; courant != null; courant = courant.getSuivant()) {
            if (courant.getValeur().equals(valeur)) {
                return true;
            }
        }
        return false;
    }
    public void ajouter(Enclos valeur){

        if (nbElement == 0) {
            NoeudEnclos courant = new NoeudEnclos(valeur);
            courant.setSuivant(premier);
            premier = dernier = courant;
            nbElement++;
        }
        else {
            NoeudEnclos courant = new NoeudEnclos(valeur);
            courant.setSuivant(premier);
            premier = courant;
            nbElement++;
        }
    }
    public NoeudEnclos retirer(){
        /* pour la pile
        if (premier == null){
            return null;
        }
        premier = premier.getSuivant();
        return null;

        */

        if (premier == null || premier.getSuivant() == null){
            if (premier == null)
                return null;

            premier = premier.getSuivant();
            --nbElement;
            return null;
        }

        NoeudEnclos courant = premier;
        while (courant.getSuivant().getSuivant() != null)
            courant = courant.getSuivant();

        courant.setSuivant(null);
        --nbElement;
        return premier;
    }
    public String toString(){
        //TODO
        System.out.print(" " + nbElement + " éléments: ");
        for (NoeudEnclos courant = premier; courant != null; courant = courant.getSuivant()){
            System.out.print(courant);

        }
        return "";
    }

}
