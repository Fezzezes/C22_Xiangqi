package xiangqi.piece;

public class Char extends Piece{

    public Char(String nom, String couleur){
        super(nom, couleur);
    }

    @Override
    public boolean estValide (Position depart, Position arrivee){

    //•	S’apparente à la Tour dans le jeu d’échecs occidental
    //•	Il peut avancer d’un nombre illimité d’intersections en autant qu’il demeure sur la même ligne ou sur la même colonne

        //Le déplacement doit avoir la même ligne ou la même colonne
        System.out.println("Même ligne ou colonne: "+(depart.getColonne() == arrivee.getColonne() || depart.getLigne() == arrivee.getLigne()));
        return (depart.getColonne() == arrivee.getColonne() || depart.getLigne() == arrivee.getLigne());

    }
}
