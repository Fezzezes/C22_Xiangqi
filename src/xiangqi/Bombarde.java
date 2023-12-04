package xiangqi;

public class Bombarde extends Piece{

    public Bombarde(String nom, String couleur){
        super(nom, couleur);
    }

    @Override
    public boolean estValide (Position depart, Position arrivee){

    //•	Pour l’étape 1, elle se déplace comme un char (rook)
    //•	Pour les étapes futures, lorsqu’il y aura d’autres pièces sur l’échiquier, elle peut capturer seulement une pièce s’il y a exactement une pièce entre la bombarde et sa cible.

        return false;
    }

}
