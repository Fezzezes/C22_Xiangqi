package xiangqi;

public class Roi extends Piece{

    public Roi(String nom, String couleur){
        super(nom, couleur);
    }

    @Override
    public boolean estValide (Position depart, Position arrivee){return false;}
}
