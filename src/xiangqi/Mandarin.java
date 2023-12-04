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

        //un déplacement de '1' en diagonale ==  '2'm '0' représente un mouvement sur sous-même qui est aussi valide
        System.out.println("Déplacement == '2' : "+(norme(depart, arrivee) == 2 ||norme(depart, arrivee) == 0 ));

        return (norme(depart, arrivee) == 2 ||norme(depart, arrivee) == 0 ) && estDansPalais(depart,arrivee);
    }
}
