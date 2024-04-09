import java.util.Arrays;

public class Visiteur {
    private String nom;
    private int age;
    private String[] especes;
    private FileEnclos encloChoisis;
    private int nbEnclosRestant = 0;

    public Visiteur (String nom, int age, String[] especes){
        this.nom = nom.trim();
        this.age = age;
        this.especes = especes;

    }
    public void setEnclosChoisis(FileEnclos enclosChoisis){
        this.encloChoisis = enclosChoisis;

    }
    public Enclos prochainEnclos(){
        //TODO
        if (encloChoisis.getNbElements() == 0) {
            return null;
        }

        return encloChoisis.retirer().getValeur();

    }

    //Todo methode pour connaitre le nombre d<enclo restant pour le toString

    @Override
    public String toString() {
        return "[" + nom + ", " + age + " ans, " + nbEnclosRestant + " enclos restants]";
    }
}
