package xiangqi;

public class Roi extends Piece{

    public Roi(String nom, String couleur){
        super(nom, couleur);
    }

    @Override
    public boolean estValide (Position depart, Position arrivee){

        //•	Il se déplace horizontalement ou verticalement d’une intersection, PAS DIAGONALE
        //•	Doit demeurer dans son palais ( dépendant de sa couleur )
        //•	Il se déplace de ‘1’

        //retourne faux si le déplacement est plus grand qu'un '1'
        System.out.println("Déplacement == '1' : "+(norme(depart, arrivee) == 1 ||norme(depart, arrivee) == 0 ));
        return (norme(depart, arrivee) == 1 ||norme(depart, arrivee) == 0 ) && estDansPalais(arrivee);
    }
}
