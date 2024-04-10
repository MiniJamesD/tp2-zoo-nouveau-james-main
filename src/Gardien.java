public class Gardien {
    private static int generateurId = 999;
    private int id;
    private String nom;
    private Famille specialite;
    private double hrsExperience;
    private Enclos enclos;
    public Gardien(String nom, double hrsExperience, Famille specialite){
        id = generateurId + 1;
        generateurId++;
        this.nom = nom.trim();
        this.hrsExperience = hrsExperience;
        this.specialite = specialite;
        enclos = null;
    }
    public void ajouterExperience(double minutes){
        hrsExperience += (minutes / 60);
    }
    public boolean assignerA(Enclos enclos){

        if (enclos.getFamille().equals(specialite) || enclos.getNbGardiens() >= 1){
            quitterEnclos();
            this.enclos = enclos;
            this.enclos.augmenterGardiens();
            return true;
        }

        return false;
    }
    public void quitterEnclos(){
        if (enclos != null) {
            enclos.diminuerGardiens();
            enclos = null;
        }
    }
    @Override
    public String toString() {
        String str = "[" + nom + " (#" + id + "), " + hrsExperience + " hrs, enclos '";
        if (enclos == null) {
            str+= "Aucun']";
        }
        else
            str+= enclos.getNom() + "']";
        return str;
    }
    public int getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public Famille getSpecialite() {
        return specialite;
    }
    public double getHrsExperience() {
        return hrsExperience;
    }
    public Enclos getEnclos() {
        return enclos;
    }
    public static void main(String[] args) {
        //Gardien James = new Gardien("James", 10, Famille.Mammifere);
       // Gardien William = new Gardien("William", 15, Famille.Poisson);

        //System.out.println(James);


    }
}
