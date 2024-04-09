import java.util.Arrays;

public class Visiteur {
    private String nom;
    private int age;
    private String[] especes;
    private File EncloChoisis;
    private int nbEnclosRestant = 0;

    public Visiteur (String nom, int age, String[] especes){
        this.nom = nom.trim();
        this.age = age;
        this.especes = especes;
    }
    public void setEnclosChoisis(File<Enclos>enclosChoisis){
        //TODO

    }
    public Enclos prochainEnclos(){
        //TODO
        return null;
    }

    @Override
    public String toString() {
        return "[" + nom + ", " + age + " ans, " + nbEnclosRestant + "enclos restants]";
    }
}
