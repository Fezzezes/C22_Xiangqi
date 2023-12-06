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

        return piece != null?(this.piece.getNom() +this.piece.getCouleurAbrege()): "--";
    }

}
