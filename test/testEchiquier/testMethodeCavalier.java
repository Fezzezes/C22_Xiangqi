package testEchiquier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xiangqi.echiquier.Echiquier;
import xiangqi.piece.Bombarde;
import xiangqi.piece.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testMethodeCavalier {


    Echiquier echiquier;

    @BeforeEach
    public void beforeEach()
    {echiquier = new Echiquier();}


    @Test
    public void testValideCavalierHautGauche(){
        echiquier.getJeu()[2][3].setPiece(new Bombarde("B","rouge"));
        assertEquals(true, echiquier.cheminPossible(new Position(2,3), new Position(0,2)));
    }

    @Test
    public void testValideCavalierHautDroite(){
        echiquier.getJeu()[2][3].setPiece(new Bombarde("B","rouge"));
        assertEquals(true, echiquier.cheminPossible(new Position(2,3), new Position(0,4)));
    }

    @Test
    public void testValideCavalierBasGauche(){
        assertEquals(true, echiquier.cheminPossible(new Position(2,3), new Position(4,2)));
    }

    @Test
    public void testValideCavalierBasDroite(){
        assertEquals(true, echiquier.cheminPossible(new Position(2,3), new Position(4,4)));
    }

    @Test
    public void testValideCavalierGaucheHaut(){
        assertEquals(true, echiquier.cheminPossible(new Position(2,3), new Position(1,1)));
    }

    @Test
    public void testValideCavalierGaucheBas(){
        assertEquals(true, echiquier.cheminPossible(new Position(2,3), new Position(3,1)));
    }

    @Test
    public void testValideCavalierDroiteHaut(){
        assertEquals(true, echiquier.cheminPossible(new Position(2,3), new Position(1,5)));
    }

    @Test
    public void testValideCavalierDroiteBas(){
        assertEquals(true, echiquier.cheminPossible(new Position(2,3), new Position(3,5)));
    }


    @Test
    public void testValideCavalierDroiteHautSurEnnemi(){
        echiquier.getJeu()[2][3].setPiece(new Bombarde("B","rouge"));
        echiquier.getJeu()[1][5].setPiece(new Bombarde("B","noir"));
        assertEquals(true, echiquier.cheminPossible(new Position(2,3), new Position(1,5)));
    }

    @Test
    public void testValideCavalierDroiteBasEnnemi(){
        echiquier.getJeu()[2][3].setPiece(new Bombarde("B","rouge"));
        echiquier.getJeu()[3][5].setPiece(new Bombarde("B","noir"));
        assertEquals(true, echiquier.cheminPossible(new Position(2,3), new Position(3,5)));
    }


    @Test
    public void testInvalideCavalierHautGauche(){
        echiquier.getJeu()[1][3].setPiece(new Bombarde("B","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(2,3), new Position(0,2)));
    }

    @Test
    public void testInvalideCavalierHautDroite(){
        echiquier.getJeu()[1][3].setPiece(new Bombarde("B","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(2,3), new Position(0,4)));
    }

    @Test
    public void testInvalideCavalierBasGauche(){
        echiquier.getJeu()[3][3].setPiece(new Bombarde("B","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(2,3), new Position(4,2)));
    }

    @Test
    public void testInvalideCavalierBasDroite(){
        echiquier.getJeu()[3][3].setPiece(new Bombarde("B","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(2,3), new Position(4,4)));
    }

    @Test
    public void testInvalideCavalierGaucheHaut(){
        echiquier.getJeu()[2][2].setPiece(new Bombarde("B","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(2,3), new Position(1,1)));
    }

    @Test
    public void testInvalideCavalierGaucheBas(){
        echiquier.getJeu()[2][2].setPiece(new Bombarde("B","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(2,3), new Position(3,1)));
    }

    @Test
    public void testInvalideCavalierDroiteHaut(){
        echiquier.getJeu()[2][4].setPiece(new Bombarde("B","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(2,3), new Position(1,5)));
    }

    @Test
    public void testInvalideCavalierDroiteBas(){
        echiquier.getJeu()[2][4].setPiece(new Bombarde("B","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(2,3), new Position(3,5)));
    }
}
