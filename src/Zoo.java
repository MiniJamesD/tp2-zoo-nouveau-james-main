public class Zoo {
    private String nom;
    private Enclos[] enclos;
    private Pile pileGardiens;
    private FileVisiteur fileVisiteurs;

    public Zoo(String nom, Enclos[] enclos){
        this.nom = nom.trim();
        this.enclos = enclos;
        pileGardiens = new Pile();
        fileVisiteurs = new FileVisiteur();
    }
    public int getNbEnclos() {
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

        Gardien g = new Gardien(nom, hrsExperience, specialite);
        if (!g.assignerA(enclos)){
            return null;
        }
        pileGardiens.push(g);
        return g;
    }
    public Gardien engagerGardien(String nom, double hrsExperience, Famille specialite){
        int j = 0;
        Enclos tempo = null;

        for (Enclos i: enclos) {
            if (i.getFamille().equals(specialite)) {
                if (j == 0) { j = i.getNbGardiens();
                }
                if (j > i.getNbGardiens()) {
                    j = i.getNbGardiens();
                    tempo = i;
                    System.out.println(tempo);
                }
            }
        }
        if (tempo == null) {
            return null;
        }
        return engagerGardien(nom, hrsExperience, specialite, tempo);
    }

    public Gardien renvoyerGardien(){

        if (pileGardiens.peek().getEnclos().getNbGardiens() > 1){

            return pileGardiens.pop();
        }
        return null;
    }
    public Pile getGardiensDe(Enclos enclos){

        Pile temp = new Pile();
        for (int i = 0; i < pileGardiens.getNbElements(); i++){
            if (pileGardiens.get(i).getEnclos().equals(enclos)){
                temp.push(pileGardiens.get(i));

            }
        }
        return temp;
    }
    public double accueillirVisiteur(Visiteur visiteur){
        double prixTotal = (5.5 * getNbEnclos()) + getNbTotalAnimaux();

        if (visiteur.getAge() <= 6){
            prixTotal = 0;
        }
        else if (visiteur.getAge() >= 7) {
            prixTotal = (prixTotal / 2);
        }
        else if (visiteur.getAge() <= 13){
            prixTotal = (prixTotal / 2);
        }
        else if (visiteur.getAge() >=65){
            prixTotal = (prixTotal / 2);
        }


        fileVisiteurs.ajouter(visiteur);
        System.out.println(visiteur + "Entre dans le zoo.");
        return prixTotal;
    }
    public Visiteur prochainVisiteur(){
        if (fileVisiteurs.getNbElements() == 0){
            return null;
        }
        fileVisiteurs.retirer();
        return fileVisiteurs.getPremier().valeur;
    }
    public void afficherTout(){
        System.out.println("Bienvenu au zoo de " + nom + "! \nVoici la pile des gardiens");
        System.out.println("    " + pileGardiens);
        System.out.println("Et la file des visiteurs:");
        System.out.println("    " + fileVisiteurs);
        System.out.println("Le zoo est peuplé par " + getNbTotalAnimaux() + " animaux répartis dans " + getNbEnclos() + " enclos:");
        for (int i = 0; i < getNbEnclos(); i++) {
            enclos[i].afficherEnclos();
            System.out.println("Il y a " + enclos[i].getNbGardiens() + " gardien(s) assignés à cet enclos.");
        }

    }
    public Enclos[] getEnclos() {
        return enclos;
    }

    public Pile getPileGardiens() {
        return pileGardiens;
    }

    public FileVisiteur getFileVisiteurs() {
        return fileVisiteurs;
    }

}
