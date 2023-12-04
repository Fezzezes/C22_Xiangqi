package xiangqi;

public class Mandarin extends Piece{

    public Mandarin(String nom, String couleur){
        super(nom, couleur);
    }

    @Override
    public boolean estValide (Position depart, Position arrivee){return false;}
}
