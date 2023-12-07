package testEchiquier;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xiangqi.echiquier.Echiquier;
import xiangqi.piece.Bombarde;
import xiangqi.piece.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testMethodeDiagonale {

    static Echiquier echiquier;

    @BeforeAll
    public static void beforeAll() {
        echiquier = new Echiquier();
        echiquier.afficher();
    }

    @BeforeEach
    public void beforeEach()
    {echiquier = new Echiquier();}

    @Test
    public void testValideHautVersGauche(){
        assertEquals(0, echiquier.cheminPossible2(new Position(5,2), new Position(7,0)));
    }

    @Test
    public void testValideHautVersDroite(){
        assertEquals(0, echiquier.cheminPossible2(new Position(5,2), new Position(7,4)));
    }

    @Test
    public void testValideBasVersGauche(){
        assertEquals(0, echiquier.cheminPossible2(new Position(9,2), new Position(7,0)));
    }

    @Test
    public void testValideBasVersDroite(){
        assertEquals(0, echiquier.cheminPossible2(new Position(9,2), new Position(7,4)));
    }

    @Test
    public void testValideGaucheVersHaut(){
        assertEquals(0, echiquier.cheminPossible2(new Position(7,0), new Position(5,2)));
    }

    @Test
    public void testValideGaucheVersBas(){
        assertEquals(0, echiquier.cheminPossible2(new Position(7,0), new Position(9,2)));
    }

    @Test
    public void testValideDroiteVersHaut(){
        assertEquals(0, echiquier.cheminPossible2(new Position(7,4), new Position(5,2)));
    }

    @Test
    public void testValideDroiteVersBas(){
        assertEquals(0, echiquier.cheminPossible2(new Position(7,4), new Position(9,2)));
    }





    @Test
    public void testInvalideHautVersGauche(){
        echiquier.getJeu()[6][1].setPiece(new Bombarde("B","rouge"));
        assertEquals(1, echiquier.cheminPossible2(new Position(5,2), new Position(7,0)));
    }

    @Test
    public void testInvalideHautVersDroite(){
        echiquier.getJeu()[6][3].setPiece(new Bombarde("B","rouge"));
        assertEquals(1, echiquier.cheminPossible2(new Position(5,2), new Position(7,4)));
    }

    @Test
    public void testInvalideBasVersGauche(){
        echiquier.getJeu()[8][1].setPiece(new Bombarde("B","rouge"));
        assertEquals(1, echiquier.cheminPossible2(new Position(9,2), new Position(7,0)));
    }

    @Test
    public void testInvalideBasVersDroite(){
        echiquier.getJeu()[8][3].setPiece(new Bombarde("B","rouge"));
        assertEquals(1, echiquier.cheminPossible2(new Position(9,2), new Position(7,4)));
    }

    @Test
    public void testInvalideGaucheVersHaut(){
        echiquier.getJeu()[6][1].setPiece(new Bombarde("B","rouge"));
        assertEquals(1, echiquier.cheminPossible2(new Position(7,0), new Position(5,2)));
    }

    @Test
    public void testInvalideGaucheVersBas(){
        echiquier.getJeu()[8][1].setPiece(new Bombarde("B","rouge"));
        assertEquals(1, echiquier.cheminPossible2(new Position(7,0), new Position(9,2)));
    }

    @Test
    public void testInvalideDroiteVersHaut(){
        echiquier.getJeu()[6][3].setPiece(new Bombarde("B","rouge"));
        assertEquals(1, echiquier.cheminPossible2(new Position(7,4), new Position(5,2)));
    }

    @Test
    public void testInvalideDroiteVersBas(){
        echiquier.getJeu()[8][3].setPiece(new Bombarde("B","rouge"));
        assertEquals(1, echiquier.cheminPossible2(new Position(7,4), new Position(9,2)));
    }





//    @Test
//    public void testInvalideHaut9(){
//        assertEquals(2, echiquier.cheminPossible2(new Position(0,0), new Position(9,0)));
//    }
//
//    @Test
//    public void testInvalideBas9(){
//        assertEquals(2, echiquier.cheminPossible2(new Position(9,0), new Position(0,0)));
//    }
//
//    @Test
//    public void testInvalideBlockeParEnnemi(){
//        echiquier.getJeu()[7][3].setPiece(new Bombarde("B","noir"));
//        assertEquals(1, echiquier.cheminPossible2(new Position(9,3), new Position(0,3)));
//    }
//
//    @Test
//    public void testInvalideBlockeParAmi(){
//        echiquier.getJeu()[7][3].setPiece(new Bombarde("B","rouge"));
//        assertEquals(1, echiquier.cheminPossible2(new Position(9,3), new Position(0,3)));
//    }
}
