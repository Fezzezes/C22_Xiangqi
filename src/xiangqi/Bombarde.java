package xiangqi;

public class Bombarde extends Piece{

    public Bombarde(String nom, String couleur){
        super(nom, couleur);
    }

    @Override
    public boolean estValide (Position depart, Position arrivee){return false;}

}
