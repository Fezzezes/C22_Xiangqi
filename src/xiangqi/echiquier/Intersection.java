package xiangqi.echiquier;

import xiangqi.piece.Piece;

public class Intersection {

    private Piece piece;

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Intersection(){
        piece = null;
    }

    public String getPieceName() {

        //utile pour la fonction d'affichage
        return piece != null?(this.piece.getNom() +this.piece.getCouleurAbrege()): "--";
    }



}
