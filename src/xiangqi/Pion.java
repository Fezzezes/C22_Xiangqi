package xiangqi;

public class Pion extends Piece{

    public Pion(String nom, String couleur){
        super(nom, couleur);
    }

    @Override
    public boolean estValide (Position depart, Position arrivee){return false;}

}
