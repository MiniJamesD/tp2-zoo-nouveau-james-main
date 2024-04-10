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
        pileGardiens = new Pile();
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

        if (pileGardiens.peek().getEnclos().getNbGardiens() > 1){
            pileGardiens.pop();
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
        else if (visiteur.getAge() >= 7 || visiteur.getAge() <= 13 || visiteur.getAge() >=65) {
            prixTotal = (prixTotal / 2);
        }



        fileVisiteurs.ajouter(visiteur);

        return prixTotal;
    }
    public Visiteur prochainVisiteur(){
        return null;
    }
    public void afficherTout(){
        //todo
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
