package testEchiquier;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import xiangqi.echiquier.Echiquier;
import xiangqi.piece.Bombarde;
import xiangqi.piece.Char;
import xiangqi.piece.Position;


public class testMethodeColonne {

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
    public void testValideHaut1(){
        echiquier.getJeu()[3][4].setPiece(new Char("!","noir"));
        assertEquals(true, echiquier.cheminPossible(new Position(3,4), new Position(4,4)));
    }

    @Test
    public void testValideHaut8(){
        echiquier.getJeu()[0][3].setPiece(new Char("!","noir"));
        assertEquals(true, echiquier.cheminPossible(new Position(0,3), new Position(8,3)));
    }

    @Test
    public void testValideBas1(){
        echiquier.getJeu()[6][4].setPiece(new Char("!","noir"));
        assertEquals(true, echiquier.cheminPossible(new Position(6,4), new Position(5,4)));
    }

    @Test
    public void testValideBas8(){
        echiquier.getJeu()[9][3].setPiece(new Char("!","noir"));
        assertEquals(true, echiquier.cheminPossible(new Position(9,3), new Position(1,3)));
    }

    @Test
    public void testValideHaut8SurEnnemi(){
        echiquier.getJeu()[0][3].setPiece(new Char("!","noir"));
        echiquier.getJeu()[8][3].setPiece(new Bombarde("?","rouge"));
        assertEquals(true, echiquier.cheminPossible(new Position(0,3), new Position(8,3)));
    }

    @Test
    public void testValideBas8SurEnnemi(){
        echiquier.getJeu()[9][3].setPiece(new Char("!","noir"));
        echiquier.getJeu()[0][3].setPiece(new Bombarde("?","rouge"));
        assertEquals(true, echiquier.cheminPossible(new Position(9,3), new Position(0,3)));
    }


    @Test
    public void testInvalideHautBlockeParAmi(){
        echiquier.getJeu()[0][0].setPiece(new Char("!","noir"));
        echiquier.getJeu()[8][0].setPiece(new Char("?","noir"));
        assertEquals(false, echiquier.cheminPossible(new Position(0,0), new Position(9,0)));
    }

    @Test
    public void testInvalideBasBlockedParEnnemi(){
        echiquier.getJeu()[9][0].setPiece(new Char("!","noir"));
        echiquier.getJeu()[3][0].setPiece(new Char("?","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(9,0), new Position(0,0)));
    }


    @Test
    public void testInvalideHaut8SurAmi(){
        echiquier.getJeu()[0][3].setPiece(new Char("!","noir"));
        echiquier.getJeu()[8][3].setPiece(new Char("?","noir"));
        assertEquals(false, echiquier.cheminPossible(new Position(0,3), new Position(8,3)));
    }

    @Test
    public void testInvalideBas8SurAmi(){
        echiquier.getJeu()[9][3].setPiece(new Char("!","rouge"));
        echiquier.getJeu()[0][3].setPiece(new Bombarde("?","rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(9,3), new Position(0,3)));
    }





}
