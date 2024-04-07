public class Animal {

    private Famille famille;
    private String espece;
    private String nom;
    private double poids;

    public Animal(Famille famille, String espece, String nom, double poids){

        this.famille = famille;
        this.espece = espece.toLowerCase().trim();
        this.nom = nom.trim();
        this.poids = poids;

    }

    public Famille getFamille() {
        return famille;
    }

    public String getEspece() {
        return espece;
    }

    public String getNom() {
        return nom;
    }

    public double getPoids() {
        return poids;
    }

    public double setPoids(double poids){
        if(poids > 0){
            this.poids = poids;
        }
        return this.poids;
    }

    @Override
    public String toString() {
        return "    Le " + espece + " nommé " + nom + " pèse " + poids + " kg";
    }

    public static void main(String[] args) {
        Animal chat = new Animal(Famille.Mammifere, "Chat", "Miaouss", 10);
        System.out.println(chat);
    }
}
