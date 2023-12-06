package xiangqi.piece;

public class Pion extends Piece{

    public Pion(String nom, String couleur){
        super(nom, couleur);
    }

    @Override
    public boolean estValide (Position depart, Position arrivee){

    //•	De son côté de sa rivière, il avance d’une intersection à la fois en ligne droite
    //•	De l’autre côté de la rivière, il peut avancer d’une intersection à la fois en ligne droite ou sur les côtés
    //•	Il ne peut pas reculer contrairement aux autres pièces

        //un pion peut seulement avancer de '1'(ou sur place)
        if(norme(depart, arrivee) > 1 )
            return false;

        //un mouvement horizontale est seulement accepte après la rivière
        else if (arrivee.getLigne() == depart.getLigne() && !traverseLaRiviere(arrivee))
            return false;

        //un pion ne peut pas reculer
        if(this.getCouleur().equals("noir") && arrivee.getLigne() < depart.getLigne())
                return false;
        else if(this.getCouleur().equals("rouge") && arrivee.getLigne() > depart.getLigne())
                return false;

        //Seul un mouvement d'avancement ou un mouvement horizontal après la rivière de '1' peuvent atteindre ce point
        return true;
    }

}
