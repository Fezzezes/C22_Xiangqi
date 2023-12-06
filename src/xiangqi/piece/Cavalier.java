package xiangqi.piece;

public class Cavalier extends Piece{

    public Cavalier(String nom, String couleur){
        super(nom, couleur);
    }

    @Override
    public boolean estValide (Position depart, Position arrivee){

    //•	Comme aux échecs habituels, il se déplace d’abord d’une intersection en ligne droite, puis d’une case en diagonale.

        //Un déplacement de '1' plus 1 diagonale =
        System.out.println("Déplacement == : "+(norme(depart, arrivee)));
        return (norme(depart, arrivee) == 5 ||norme(depart, arrivee) == 0 );
    }
}
