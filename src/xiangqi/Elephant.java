package xiangqi;

public class Elephant extends Piece{

    public Elephant(String nom, String couleur){
        super(nom, couleur);
    }

    @Override
    public boolean estValide (Position depart, Position arrivee){

    //•	Ne peut pas traverser la rivière ( dépendant de sa couleur )
    //•	Se déplace de deux intersections DIAGONALES à la fois

        //La rivière ne peut être traversé, dependant de la couleur
        if(this.getCouleur().equals("noir") && arrivee.getLigne() > 4)
            return false;
        else if (this.getCouleur().equals("rouge") && arrivee.getLigne() < 5)
            return false;

        //un déplacement en diagonale de '2' aura toujours une distance de '8'
        System.out.println("Déplacement == '8' : "+(norme(depart, arrivee) == 8 ||norme(depart, arrivee) == 0 ));

        return (norme(depart, arrivee) == 8 ||norme(depart, arrivee) == 0 );
    }
}
