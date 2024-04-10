public class Visiteur {
    private String nom;
    private int age;
    private String[] especes;
    private FileEnclos encloChoisis = new FileEnclos();
    private int nbEnclosRestant = 0;
    public Visiteur (String nom, int age, String[] especes){
        this.nom = nom.trim();
        this.age = age;
        this.especes = especes;
    }
    public void setEnclosChoisis(FileEnclos enclosChoisis){
        this.encloChoisis = enclosChoisis;
        nbEnclosRestant = encloChoisis.getNbElements();
    }
    public Enclos prochainEnclos(){
        //TODO erreur dans les test
        if (encloChoisis.getNbElements() == 0) {
            return null;
        }
        --nbEnclosRestant;
        encloChoisis.retirer();
        return encloChoisis.getPremier().valeur;
    }
    public int getAge(){
        return age;
    }
    @Override
    public String toString() {
        return "[" + nom + ", " + age + " ans, " + nbEnclosRestant + " enclos restants]";
    }
}
