public class Enclos {
    private Famille famille;
    private String nom;
    private int nbGardiens;
    private int nbAnimaux;
    private int capaciteMax;
    private Animal[] animaux;

    public Enclos(Famille famille, String nom, int capaciteMax){
        this.famille = famille;
        this.nom = nom.trim();
        this.nbGardiens = 0;
        this.nbAnimaux = 0;
        this.capaciteMax = capaciteMax;

        Animal[] tempo = new Animal[capaciteMax];
        this.animaux = tempo;

    }

    public Famille getFamille() {
        return famille;
    }

    public String getNom() {
        return nom;
    }

    public int getNbGardiens() {
        return nbGardiens;
    }

    public int getNbAnimaux() {
        return nbAnimaux;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public Animal[] getAnimaux() {
        return animaux;
    }

    public int augmenterGardiens(){
        nbGardiens++;
        return nbGardiens;
    }
    public int diminuerGardiens(){
        if(nbGardiens > 0){
            --nbGardiens;
        }
        return nbGardiens;
    }

    public boolean ajouterAnimal(Animal animal){
        if (nbAnimaux == capaciteMax) {
            System.out.println("Capacité maximal déja atteinte l'animal n'est pas ajouté");
            return false;
        }
        if (animal.getFamille().equals(this.famille)) {
            animaux[nbAnimaux] = animal;
            nbAnimaux++;
            System.out.println(animal.getNom() + " le " + animal.getEspece() + " a été ajouté à l'enclos '" + nom + "'.");
            return true;
        }
        return false;
    }
    public boolean ajouterAnimal(Animal[] animaux){
        int nbAnimauxAttendue = animaux.length + nbAnimaux;

        for (Animal animal : animaux) {
            if (animal.getFamille().equals(this.famille)) {
                ajouterAnimal(animal);
            }
        }
        return nbAnimauxAttendue == nbAnimaux;
    }
    public boolean contientEspece(String espece){

        for (int i = 0; i < nbAnimaux; i++){
            if (animaux[i].getEspece().equals(espece)){
                return true;
            }
        }
        return false;
    }
    public void afficherEnclos(){
        System.out.println("L'enclos '" + nom + "' contient " + nbAnimaux + " "+ famille + ":");
        for (int i = 0; i < nbAnimaux; i++){
            System.out.println(animaux[i]);
        }
    }

    public static void main(String[] args) {
        Enclos mammifere = new Enclos(Famille.Mammifere,"Les Mammifere", 4);

        Animal chat1 = new Animal(Famille.Mammifere, "Chat", "Miaouss", 10);
        Animal chien1 = new Animal(Famille.Mammifere, "Chien", "Oreo", 20);
        Animal chat2 = new Animal(Famille.Mammifere, "Chat", "Caramel", 16);
        Animal chat3 = new Animal(Famille.Mammifere, "Chat", "Choco", 11);
        Animal chien2 = new Animal(Famille.Mammifere, "Chien", "Patate", 14);

        mammifere.ajouterAnimal(chat1);

        mammifere.afficherEnclos();
        System.out.println();

        mammifere.ajouterAnimal(chien1);
        mammifere.ajouterAnimal(chien2);
        mammifere.ajouterAnimal(chat2);
        mammifere.ajouterAnimal(chat3);

        mammifere.afficherEnclos();



        System.out.println(mammifere.contientEspece("chien"));


        Enclos mammifere2 = new Enclos(Famille.Mammifere,"Les Mammifere2", 4);

    }
}
