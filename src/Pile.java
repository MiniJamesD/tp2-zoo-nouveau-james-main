import java.util.Arrays;

public class Pile {
    public static int TAILLE_INITIALE = 5, RATIO_AGRANDISSEMENT = 2;
    private int nbElement = 0;
    private Gardien[] gardiens = new Gardien[TAILLE_INITIALE];

    public Gardien get(int index){
        return gardiens[index];
    }
    public Gardien peek(){
        return gardiens[nbElement - 1];
    }
    public void push(Gardien g){
        resize();
        gardiens[nbElement] = g;
        nbElement++;
    }
    public Gardien pop(){
        --nbElement;
        gardiens[nbElement].getEnclos().diminuerGardiens();

        return gardiens[nbElement];
    }

    public int getNbElements() {
        return nbElement;
    }
    private void resize(){
        if (nbElement == gardiens.length) {
            Gardien[] tempo = new Gardien[gardiens.length * RATIO_AGRANDISSEMENT];
            System.arraycopy(gardiens, 0, tempo, 0, gardiens.length);
            gardiens = tempo;
        }
    }
    @Override
    public String toString() {
        String str = nbElement + " gardiens: ";
        for (int i = 0; i < nbElement; i++){
            str += gardiens[i];
            if (i == nbElement- 1){
                str += ".";
            }
            else {
                str += " | ";
            }
        }
        return str;
    }

    public boolean estVide() {
        if (nbElement > 1){
            return false;
        }
        else {
            return true;
        }
    }
}
