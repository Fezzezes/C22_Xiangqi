package testEchiquier;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xiangqi.echiquier.Echiquier;
import xiangqi.piece.Bombarde;
import xiangqi.piece.Char;
import xiangqi.piece.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testMethodeDiagonale {

    static Echiquier echiquier;

    @BeforeEach
    public void beforeEach()
    {echiquier = new Echiquier();}

    @AfterEach
    public  void afterEach(){
        System.out.println("");
        echiquier.afficher();
    }

    @Test
    public void testValideDeplacementNULL(){
        echiquier.getJeu()[2][7].setPiece(new Char("!","noir"));
        assertEquals(true, echiquier.cheminPossible(new Position(2,7), new Position(2,7)));
    }

    @Test
    public void testValideBasVersGauche(){
        echiquier.getJeu()[5][2].setPiece(new Char("!","noir"));
        assertEquals(true, echiquier.cheminPossible(new Position(5,2), new Position(7,0)));
    }

    @Test
    public void testValideBasVersDroite(){
        echiquier.getJeu()[5][2].setPiece(new Char("!","noir"));
        assertEquals(true, echiquier.cheminPossible(new Position(5,2), new Position(7,4)));
    }

    @Test
    public void testValideHautVersGauche(){
        echiquier.getJeu()[9][2].setPiece(new Char("!","noir"));
        assertEquals(true, echiquier.cheminPossible(new Position(9,2), new Position(7,0)));
    }

    @Test
    public void testValideHautVersDroite(){
        echiquier.getJeu()[9][2].setPiece(new Char("!","noir"));
        assertEquals(true, echiquier.cheminPossible(new Position(9,2), new Position(7,4)));
    }


    @Test
    public void testValideHautVersGaucheSurEnnemi(){
        echiquier.getJeu()[7][4].setPiece(new Char("!","noir"));
        echiquier.getJeu()[5][2].setPiece(new Bombarde("?","rouge"));
        assertEquals(true, echiquier.cheminPossible(new Position(7,4), new Position(5,2)));
    }

    @Test
    public void testValideBasVersDroiteSurEnnemi(){
        echiquier.getJeu()[7][4].setPiece(new Char("!","noir"));
        echiquier.getJeu()[9][2].setPiece(new Bombarde("?","rouge"));
        assertEquals(true, echiquier.cheminPossible(new Position(7,4), new Position(9,6)));
    }


    @Test
    public void testInvalideBasVersGauche(){
        echiquier.getJeu()[5][2].setPiece(new Char("!","noir"));
        echiquier.getJeu()[6][1].setPiece(new Bombarde("B","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(5,2), new Position(7,0)));
    }

    @Test
    public void testInvalideBasVersDroite(){
        echiquier.getJeu()[5][2].setPiece(new Char("!","noir"));
        echiquier.getJeu()[6][3].setPiece(new Bombarde("B","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(5,2), new Position(7,4)));
    }

    @Test
    public void testInvalideHautVersGauche(){
        echiquier.getJeu()[9][2].setPiece(new Char("!","noir"));
        echiquier.getJeu()[8][1].setPiece(new Bombarde("B","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(9,2), new Position(7,0)));
    }

    @Test
    public void testInvalideHautVersDroite(){
        echiquier.getJeu()[9][2].setPiece(new Char("!","noir"));
        echiquier.getJeu()[8][3].setPiece(new Bombarde("B","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(9,2), new Position(7,4)));
    }


    @Test
    public void testInvalideHautVersGaucheSurAmi(){
        echiquier.getJeu()[7][4].setPiece(new Char("!","noir"));
        echiquier.getJeu()[5][2].setPiece(new Bombarde("?","noir"));
        assertEquals(false, echiquier.cheminPossible(new Position(7,4), new Position(5,2)));
    }

    @Test
    public void testInvalideBasVersDroiteSurAmi(){
        echiquier.getJeu()[7][4].setPiece(new Char("!","rouge"));
        echiquier.getJeu()[9][6].setPiece(new Bombarde("?","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(7,4), new Position(9,6)));
    }
}
