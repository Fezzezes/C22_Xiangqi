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
        assertEquals(true, echiquier.cheminPossible(new Position(5,2), new Position(7,0)));
    }

    @Test
    public void testValideHautVersDroite(){
        assertEquals(true, echiquier.cheminPossible(new Position(5,2), new Position(7,4)));
    }

    @Test
    public void testValideBasVersGauche(){
        assertEquals(true, echiquier.cheminPossible(new Position(9,2), new Position(7,0)));
    }

    @Test
    public void testValideBasVersDroite(){
        assertEquals(true, echiquier.cheminPossible(new Position(9,2), new Position(7,4)));
    }

    @Test
    public void testValideGaucheVersHaut(){
        assertEquals(true, echiquier.cheminPossible(new Position(7,0), new Position(5,2)));
    }

    @Test
    public void testValideGaucheVersBas(){
        echiquier.getJeu()[7][0].setPiece(new Bombarde("B","noir"));
        assertEquals(true, echiquier.cheminPossible(new Position(7,0), new Position(9,2)));
    }

    @Test
    public void testValideDroiteVersHaut(){
        assertEquals(true, echiquier.cheminPossible(new Position(7,4), new Position(5,2)));
    }

    @Test
    public void testValideDroiteVersBas(){
        echiquier.getJeu()[7][4].setPiece(new Bombarde("B","noir"));
        assertEquals(true, echiquier.cheminPossible(new Position(7,4), new Position(9,2)));
    }

    @Test
    public void testValideDroiteVersHautSurEnnemi(){
        echiquier.getJeu()[7][4].setPiece(new Bombarde("B","noir"));
        echiquier.getJeu()[5][2].setPiece(new Bombarde("B","rouge"));
        assertEquals(true, echiquier.cheminPossible(new Position(7,4), new Position(5,2)));
    }

    @Test
    public void testValideDroiteVersBasSurEnnemi(){
        echiquier.getJeu()[7][4].setPiece(new Bombarde("B","noir"));
        echiquier.getJeu()[9][2].setPiece(new Bombarde("B","rouge"));
        assertEquals(true, echiquier.cheminPossible(new Position(7,4), new Position(9,2)));
    }



    @Test
    public void testInvalideHautVersGauche(){
        echiquier.getJeu()[6][1].setPiece(new Bombarde("B","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(5,2), new Position(7,0)));
    }

    @Test
    public void testInvalideHautVersDroite(){
        echiquier.getJeu()[6][3].setPiece(new Bombarde("B","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(5,2), new Position(7,4)));
    }

    @Test
    public void testInvalideBasVersGauche(){
        echiquier.getJeu()[8][1].setPiece(new Bombarde("B","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(9,2), new Position(7,0)));
    }

    @Test
    public void testInvalideBasVersDroite(){
        echiquier.getJeu()[8][3].setPiece(new Bombarde("B","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(9,2), new Position(7,4)));
    }

    @Test
    public void testInvalideGaucheVersHaut(){
        echiquier.getJeu()[6][1].setPiece(new Bombarde("B","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(7,0), new Position(5,2)));
    }

    @Test
    public void testInvalideGaucheVersBas(){
        echiquier.getJeu()[8][1].setPiece(new Bombarde("B","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(7,0), new Position(9,2)));
    }

    @Test
    public void testInvalideDroiteVersHaut(){
        echiquier.getJeu()[6][3].setPiece(new Bombarde("B","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(7,4), new Position(5,2)));
    }

    @Test
    public void testInvalideDroiteVersBas(){
        echiquier.getJeu()[8][3].setPiece(new Bombarde("B","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(7,4), new Position(9,2)));
    }

    @Test
    public void testInvalideDroiteVersHautSurAmi(){
        echiquier.getJeu()[7][4].setPiece(new Bombarde("B","noir"));
        echiquier.getJeu()[5][2].setPiece(new Bombarde("B","noir"));
        assertEquals(false, echiquier.cheminPossible(new Position(7,4), new Position(5,2)));
    }

    @Test
    public void testInvalideDroiteVersBasSurAmi(){
        echiquier.getJeu()[7][4].setPiece(new Bombarde("B","rouge"));
        echiquier.getJeu()[9][2].setPiece(new Bombarde("B","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(7,4), new Position(9,2)));
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
