public class Zoo {
    private String nom;
    private Enclos[] enclos;
    private Pile<Gardien> pileGardiens;
    private File<Visiteur> fileVisiteurs;

    public Zoo(String nom, Enclos[] enclos){
        this.nom = nom.trim();
        this.enclos = enclos;
    }
    public int getNbEnclos(){
        return enclos.length;
    }
    public int getNbTotalAnimaux(){
        int nbTotalAnimaux = 0;
        for (int i = 0; i < getNbEnclos(); i++){
            nbTotalAnimaux += enclos[i].getNbAnimaux();
        }
        return nbTotalAnimaux;
    }
    public Gardien engagerGardien(String nom, double hrsExperience, Famille specialite, Enclos enclos) {

        // doit etre ajouter a la file
        Gardien g = new Gardien(nom, hrsExperience, specialite);
        if (g.assignerA(enclos) == false){
            return null;
        }

        return g;
    }
    public Gardien engagerGardien(String nom, double hrsExperience, Famille specialite){
        return null;
    }

}
