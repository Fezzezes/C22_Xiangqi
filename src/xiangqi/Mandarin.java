package xiangqi;

public class Mandarin extends Piece{

    public Mandarin(String nom, String couleur){
        super(nom, couleur);
    }

    @Override
    public boolean estValide (Position depart, Position arrivee){

    //•	Il se déplace d’une intersection en diagonale à la fois
    //•	Lui aussi doit demeurer dans son palais d’origine
    //•	Il se déplace de ‘1’



        return false;
    }
}
