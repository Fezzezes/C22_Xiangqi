package xiangqi;

public class Pion extends Piece{

    public Pion(String nom, String couleur){
        super(nom, couleur);
    }

    @Override
    public boolean estValide (Position depart, Position arrivee){

    //•	De son côté de sa rivière, il avance d’une intersection à la fois en ligne droite
    //•	De l’autre côté de la rivière, il peut avancer d’une intersection à la fois en ligne droite ou sur les côtés
    //•	Il ne peut pas reculer contrairement aux autres pièces

        return false;
    }

}
