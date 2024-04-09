public class NoeudEnclos {

    public Enclos valeur;
    public NoeudEnclos suivant;

    public NoeudEnclos(Enclos valeur){
        this.valeur = valeur;
        this.suivant = null;
    }

    public void setSuivant(NoeudEnclos suivant) {
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

    public Enclos getValeur() {
        return valeur;
    }

    public NoeudEnclos getSuivant() {
        return suivant;
    }
}
