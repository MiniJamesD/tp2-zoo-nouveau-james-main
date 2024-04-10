import java.util.Arrays;
import java.util.Comparator;
public class Zoo {
    private String nom;
    private Enclos[] enclos;
    private Pile pileGardiens;
    private FileVisiteur fileVisiteurs;

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
        //TODO
        Gardien g = new Gardien(nom, hrsExperience, specialite);
        if (!g.assignerA(enclos)){
            return null;
        }
        pileGardiens.push(g);
        return g;
    }
    public Gardien engagerGardien(String nom, double hrsExperience, Famille specialite){

        Gardien g = new Gardien(nom,hrsExperience,specialite);
        int[] choixPossible = new int[enclos.length];
        int nbChoixPossible = 0;
        int j = 0;
        for (int i = 0; i < enclos.length; i++) {
            if (specialite.equals(enclos[i].getFamille())){
                choixPossible[j] = enclos[i].getNbGardiens();
                j++; nbChoixPossible++;
            }
        }
        //todo
        Arrays.sort(choixPossible);



        return null;
    }

    public Gardien renvoyerGardien(){
        //todo enlever le dernier gardien engagé
        if (pileGardiens.peek().getEnclos().getNbGardiens() > 1){
            pileGardiens.pop();
        }
        return null;
    }
    public Pile getGardienDe(Enclos enclos){
        //todo
        return null;
    }
    public double accueillirVisiteur(Visiteur visiteur){
        return -1;
    }
    public Visiteur prochainVisiteur(){
        return null;
    }
    public void afficherTout(){
        //todo
    }






}
