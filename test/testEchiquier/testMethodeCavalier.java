package testEchiquier;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xiangqi.echiquier.Echiquier;
import xiangqi.piece.Bombarde;
import xiangqi.piece.Cavalier;
import xiangqi.piece.Char;
import xiangqi.piece.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testMethodeCavalier {

    Echiquier echiquier;

    @BeforeEach
    public void beforeEach()
    {
        echiquier = new Echiquier();
        echiquier.getJeu()[2][3].setPiece(new Cavalier("!","noir"));
    }

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
    public void testValideCavalierHautGauche(){
        echiquier.getJeu()[0][3].setPiece(new Cavalier("X","noir"));
        echiquier.getJeu()[1][2].setPiece(new Cavalier("X","rouge"));
        assertEquals(true, echiquier.cheminPossible(new Position(2,3), new Position(0,2)));
    }

    @Test
    public void testValideCavalierHautDroite(){
        echiquier.getJeu()[0][3].setPiece(new Cavalier("X","noir"));
        echiquier.getJeu()[1][4].setPiece(new Cavalier("X","rouge"));
        assertEquals(true, echiquier.cheminPossible(new Position(2,3), new Position(0,4)));
    }

    @Test
    public void testValideCavalierBasGauche(){
        echiquier.getJeu()[3][2].setPiece(new Cavalier("X","noir"));
        echiquier.getJeu()[4][3].setPiece(new Cavalier("X","rouge"));
        assertEquals(true, echiquier.cheminPossible(new Position(2,3), new Position(4,2)));
    }

    @Test
    public void testValideCavalierBasDroite(){
        echiquier.getJeu()[4][3].setPiece(new Cavalier("X","noir"));
        echiquier.getJeu()[3][4].setPiece(new Cavalier("X","rouge"));
        assertEquals(true, echiquier.cheminPossible(new Position(2,3), new Position(4,4)));
    }

    @Test
    public void testValideCavalierGaucheHaut(){
        echiquier.getJeu()[1][2].setPiece(new Cavalier("X","noir"));
        echiquier.getJeu()[2][1].setPiece(new Cavalier("X","rouge"));
        assertEquals(true, echiquier.cheminPossible(new Position(2,3), new Position(1,1)));
    }

    @Test
    public void testValideCavalierGaucheBas(){
        echiquier.getJeu()[2][1].setPiece(new Cavalier("X","noir"));
        echiquier.getJeu()[3][2].setPiece(new Cavalier("X","rouge"));
        assertEquals(true, echiquier.cheminPossible(new Position(2,3), new Position(3,1)));
    }

    @Test
    public void testValideCavalierDroiteHaut(){
        echiquier.getJeu()[2][5].setPiece(new Cavalier("X","noir"));
        echiquier.getJeu()[1][4].setPiece(new Cavalier("X","rouge"));
        assertEquals(true, echiquier.cheminPossible(new Position(2,3), new Position(1,5)));
    }

    @Test
    public void testValideCavalierDroiteBas(){
        echiquier.getJeu()[3][4].setPiece(new Cavalier("X","noir"));
        echiquier.getJeu()[2][5].setPiece(new Cavalier("X","rouge"));
        assertEquals(true, echiquier.cheminPossible(new Position(2,3), new Position(3,5)));
    }


    @Test
    public void testValideCavalierDroiteHautSurEnnemi(){
        echiquier.getJeu()[2][5].setPiece(new Cavalier("X","noir"));
        echiquier.getJeu()[1][4].setPiece(new Cavalier("X","rouge"));
        echiquier.getJeu()[1][5].setPiece(new Bombarde("?","rouge"));
        assertEquals(true, echiquier.cheminPossible(new Position(2,3), new Position(1,5)));
    }

    @Test
    public void testValideCavalierGaucheBasEnnemi(){
        echiquier.getJeu()[2][1].setPiece(new Cavalier("X","noir"));
        echiquier.getJeu()[3][2].setPiece(new Cavalier("X","rouge"));
        echiquier.getJeu()[3][1].setPiece(new Bombarde("?","rouge"));
        assertEquals(true, echiquier.cheminPossible(new Position(2,3), new Position(3,1)));
    }


    @Test
    public void testInvalideCavalierHautGauche(){
        echiquier.getJeu()[1][3].setPiece(new Bombarde("X","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(2,3), new Position(0,2)));
    }

    @Test
    public void testInvalideCavalierHautDroite(){
        echiquier.getJeu()[1][3].setPiece(new Bombarde("X","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(2,3), new Position(0,4)));
    }

    @Test
    public void testInvalideCavalierBasGauche(){
        echiquier.getJeu()[3][3].setPiece(new Bombarde("X","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(2,3), new Position(4,2)));
    }

    @Test
    public void testInvalideCavalierBasDroite(){
        echiquier.getJeu()[3][3].setPiece(new Bombarde("X","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(2,3), new Position(4,4)));
    }

    @Test
    public void testInvalideCavalierGaucheHaut(){
        echiquier.getJeu()[2][2].setPiece(new Bombarde("X","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(2,3), new Position(1,1)));
    }

    @Test
    public void testInvalideCavalierGaucheBas(){
        echiquier.getJeu()[2][2].setPiece(new Bombarde("X","noir"));
        assertEquals(false, echiquier.cheminPossible(new Position(2,3), new Position(3,1)));
    }

    @Test
    public void testInvalideCavalierDroiteHaut(){
        echiquier.getJeu()[2][4].setPiece(new Bombarde("X","noir"));
        assertEquals(false, echiquier.cheminPossible(new Position(2,3), new Position(1,5)));
    }

    @Test
    public void testInvalideCavalierDroiteBas(){
        echiquier.getJeu()[2][4].setPiece(new Bombarde("X","noir"));
        assertEquals(false, echiquier.cheminPossible(new Position(2,3), new Position(3,5)));
    }

    @Test
    public void testInvalideCavalierDroiteHautSurAmi(){
        echiquier.getJeu()[1][5].setPiece(new Bombarde("B","noir"));
        assertEquals(false, echiquier.cheminPossible(new Position(2,3), new Position(1,5)));
    }

    @Test
    public void testInvalideCavalierGaucheBasAmi(){
        echiquier.getJeu()[3][1].setPiece(new Bombarde("B","noir"));
        assertEquals(false, echiquier.cheminPossible(new Position(2,3), new Position(3,1)));
    }
}
