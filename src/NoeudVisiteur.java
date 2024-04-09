public class NoeudVisiteur {

    public Visiteur valeur;
    public NoeudVisiteur suivant;

    public NoeudVisiteur(Visiteur valeur){
        this.valeur = valeur;
        this.suivant = null;
    }

    public void setSuivant(NoeudVisiteur suivant) {
        this.suivant = suivant;
    }

    @Override
    public String toString() {
        String str = "";
        str += valeur; // + " -> " ;
        /*
        if (suivant == null) {

           str += "<null>";
        }

         */
        return str;
    }

    public Visiteur getValeur() {
        return valeur;
    }

    public NoeudVisiteur getSuivant() {
        return suivant;
    }

}
