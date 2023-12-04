package xiangqi;

public class Elephant extends Piece{

    public Elephant(String nom, String couleur){
        super(nom, couleur);
    }

    @Override
    public boolean estValide (Position depart, Position arrivee){

    //•	Ne peut pas traverser la rivière ( dépendant de sa couleur )
    //•	Se déplace de deux intersections DIAGONALES à la fois



        return false;
    }
}
