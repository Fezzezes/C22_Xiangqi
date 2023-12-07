package testEchiquier;

import org.junit.jupiter.api.*;
import xiangqi.echiquier.Echiquier;
import xiangqi.piece.Bombarde;
import xiangqi.piece.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testBombarde {

    Echiquier echiquier;

    @BeforeEach
    public void beforeEach()
    {echiquier = new Echiquier();}

    // déplacement à la verticale

    @Test
    public void testValideHaut1(){
        echiquier.getJeu()[3][4].setPiece(new Bombarde("B","noir"));
        echiquier.getJeu()[4][4].setPiece(null);
        assertEquals(true, echiquier.cheminPossible(new Position(3,4), new Position(4,4)));
    }

    @Test
    public void testValideHaut8(){
        echiquier.getJeu()[0][3].setPiece(new Bombarde("B","noir"));
        echiquier.getJeu()[8][3].setPiece(null);
        assertEquals(true, echiquier.cheminPossible(new Position(0,3), new Position(8,3)));
    }

    @Test
    public void testValideBas1(){
        echiquier.getJeu()[6][4].setPiece(new Bombarde("B","noir"));
        echiquier.getJeu()[5][4].setPiece(null);
        assertEquals(true, echiquier.cheminPossible(new Position(6,4), new Position(5,4)));
    }

    @Test
    public void testValideBas8(){
        echiquier.getJeu()[9][3].setPiece(new Bombarde("B","noir"));
        echiquier.getJeu()[1][3].setPiece(null);
        assertEquals(true, echiquier.cheminPossible(new Position(9,3), new Position(1,3)));
    }

    @Test
    public void testInvalideHaut9(){
        echiquier.getJeu()[0][0].setPiece(new Bombarde("B","noir"));
        echiquier.getJeu()[9][0].setPiece(null);
        assertEquals(false, echiquier.cheminPossible(new Position(0,0), new Position(9,0)));
    }

    @Test
    public void testInvalideBas9(){
        echiquier.getJeu()[9][0].setPiece(new Bombarde("B","noir"));
        echiquier.getJeu()[0][0].setPiece(null);
        assertEquals(false, echiquier.cheminPossible(new Position(9,0), new Position(0,0)));
    }

    @Test
    public void testInvalideBlockeParEnnemi(){
        echiquier.getJeu()[9][3].setPiece(new Bombarde("B","noir"));
        echiquier.getJeu()[5][3].setPiece(new Bombarde("B","rouge"));
        echiquier.getJeu()[0][3].setPiece(null);
        assertEquals(false, echiquier.cheminPossible(new Position(9,3), new Position(0,3)));
    }

    @Test
    public void testInvalideBlockeParAmi(){
        echiquier.getJeu()[9][3].setPiece(new Bombarde("B","rouge"));
        echiquier.getJeu()[5][3].setPiece(new Bombarde("B","rouge"));
        echiquier.getJeu()[0][3].setPiece(null);
        assertEquals(false, echiquier.cheminPossible(new Position(9,3), new Position(0,3)));
    }

    @Test
    public void testInvalideHaut8SurAmiVertical(){
        echiquier.getJeu()[0][3].setPiece(new Bombarde("B","noir"));
        echiquier.getJeu()[8][3].setPiece(new Bombarde("B","noir"));
        assertEquals(false, echiquier.cheminPossible(new Position(0,3), new Position(8,3)));
    }

    @Test
    public void testInvalideBas8SurAmiVertical(){
        echiquier.getJeu()[9][3].setPiece(new Bombarde("B","rouge"));
        echiquier.getJeu()[0][3].setPiece(new Bombarde("B","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(9,3), new Position(0,3)));
    }

    @Test
    public void testInvalideHaut8CaptureSansBloque(){
        echiquier.getJeu()[0][3].setPiece(new Bombarde("B","noir"));
        echiquier.getJeu()[8][3].setPiece(new Bombarde("B","noir"));
        assertEquals(false, echiquier.cheminPossible(new Position(0,3), new Position(8,3)));
    }



    // déplacement à la horizontal

    @Test
    public void testValideLigneVersLaDroite1(){
        echiquier.getJeu()[2][7].setPiece(new Bombarde("B","rouge"));
        echiquier.getJeu()[2][8].setPiece(null);
        assertEquals(true, echiquier.cheminPossible(new Position(2,7), new Position(2,8)));
    }
    @Test
    public void testValideLigneVersLaDroite8(){
        echiquier.getJeu()[1][0].setPiece(new Bombarde("B","rouge"));
        echiquier.getJeu()[1][8].setPiece(null);
        assertEquals(true, echiquier.cheminPossible(new Position(1,0), new Position(1,8)));
    }

    @Test
    public void testValideLigneVersLaGauche1(){
        echiquier.getJeu()[2][7].setPiece(new Bombarde("B","rouge"));
        echiquier.getJeu()[2][6].setPiece(null);
        assertEquals(true, echiquier.cheminPossible(new Position(2,7), new Position(2,6)));
    }

    @Test
    public void testValideLigneVersLaGauche8(){
        echiquier.getJeu()[1][8].setPiece(new Bombarde("B","rouge"));
        echiquier.getJeu()[1][0].setPiece(null);
        assertEquals(true, echiquier.cheminPossible(new Position(1,8), new Position(1,0)));
    }

    @Test
    public void testInvalideLigneVersLaDroite8(){
        echiquier.getJeu()[0][0].setPiece(new Bombarde("B","noir"));
        assertEquals(false, echiquier.cheminPossible(new Position(0,0), new Position(0,8)));
    }


    @Test
    public void testInvalideLigneVersLaGauche8(){
        echiquier.getJeu()[0][8].setPiece(new Bombarde("B","noir"));
        assertEquals(false, echiquier.cheminPossible(new Position(0,8), new Position(0,0)));
    }


    @Test
    public void testInvalideBlockeParEnnemiHorizontal(){
        echiquier.getJeu()[2][1].setPiece(new Bombarde("B","rouge"));
        echiquier.getJeu()[2][4].setPiece(new Bombarde("B","noir"));
        echiquier.getJeu()[2][6].setPiece(null);
        assertEquals(false, echiquier.cheminPossible(new Position(2,1), new Position(2,6)));
    }

    @Test
    public void testInvalideBlockeParAmiHorizontal(){
        echiquier.getJeu()[2][1].setPiece(new Bombarde("B","rouge"));
        echiquier.getJeu()[2][4].setPiece(new Bombarde("B","rouge"));
        echiquier.getJeu()[2][6].setPiece(null);
        assertEquals(false, echiquier.cheminPossible(new Position(2,1), new Position(2,6)));
    }

    @Test
    public void testInvalideLigneVersLaGauche8SurAmi(){
        echiquier.getJeu()[1][8].setPiece(new Bombarde("B","rouge"));
        echiquier.getJeu()[1][4].setPiece(new Bombarde("B","rouge"));
        echiquier.getJeu()[1][0].setPiece(new Bombarde("B","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(1,8), new Position(1,0)));
    }

    @Test
    public void testInvalideLigneVersLaDroite8SurAmi(){
        echiquier.getJeu()[1][0].setPiece(new Bombarde("B","rouge"));
        echiquier.getJeu()[1][4].setPiece(new Bombarde("B","rouge"));
        echiquier.getJeu()[1][8].setPiece(new Bombarde("B","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(1,0), new Position(1,8)));
    }

    //scénario de capture

}
