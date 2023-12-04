package xiangqi;

public class Cavalier extends Piece{

    public Cavalier(String nom, String couleur){
        super(nom, couleur);
    }

    @Override
    public boolean estValide (Position depart, Position arrivee){

    //•	Comme aux échecs habituels, il se déplace d’abord d’une intersection en ligne droite, puis d’une case en diagonale.

        return false;
    }
}
