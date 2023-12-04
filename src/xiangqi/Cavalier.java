package xiangqi;

public class Cavalier extends Piece{

    public Cavalier(String nom, String couleur){
        super(nom, couleur);
    }

    @Override
    public boolean estValide (Position depart, Position arrivee){return false;}
}
