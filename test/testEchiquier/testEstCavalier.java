package testEchiquier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xiangqi.echiquier.Echiquier;
import xiangqi.piece.Bombarde;
import xiangqi.piece.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testEstCavalier {

    Echiquier echiquier;

    @BeforeEach
    public void beforeEach()
    {echiquier = new Echiquier();}


    @Test
    public void testEstUnCavalierHautGauche(){
        assertEquals(true, echiquier.estUnCavalier(new Position(2,4), new Position(0,3)));
    }

    @Test
    public void testEstUnCavalierHautDroite(){
        assertEquals(true, echiquier.estUnCavalier(new Position(2,4), new Position(0,5)));
    }

    @Test
    public void testEstUnCavalierBasGauche(){
        assertEquals(true, echiquier.estUnCavalier(new Position(2,4), new Position(4,3)));
    }

    @Test
    public void testEstUnCavalierBasDroite(){
        assertEquals(true, echiquier.estUnCavalier(new Position(2,4), new Position(4,5)));
    }

    @Test
    public void testEstUnCavalierGaucheHaut(){
        assertEquals(true, echiquier.estUnCavalier(new Position(2,4), new Position(1,2)));
    }

    @Test
    public void testEstUnCavalierGaucheDroite(){
        assertEquals(true, echiquier.estUnCavalier(new Position(2,4), new Position(3,1)));
    }

    @Test
    public void testEstUnCavalierDroiteHaut(){
        assertEquals(true, echiquier.estUnCavalier(new Position(2,4), new Position(1,6)));
    }

    @Test
    public void testEstUnCavalierDroiteBas(){
        assertEquals(true, echiquier.estUnCavalier(new Position(2,4), new Position(3,6)));
    }

    @Test
    public void testInvalideHautVersGauche(){
        echiquier.getJeu()[6][1].setPiece(new Bombarde("B","rouge"));
        assertEquals(false, echiquier.estUnCavalier(new Position(5,2), new Position(7,0)));
    }

    @Test
    public void testInvalideHautVersDroite(){
        assertEquals(false, echiquier.estUnCavalier(new Position(5,2), new Position(7,4)));
    }

    @Test
    public void testInvalideBasVersGauche(){
        assertEquals(false, echiquier.estUnCavalier(new Position(9,2), new Position(7,0)));
    }

    @Test
    public void testInvalideBasVersDroite(){
        assertEquals(false, echiquier.estUnCavalier(new Position(9,2), new Position(7,4)));
    }

    @Test
    public void testInvalideGaucheVersHaut(){
        assertEquals(false, echiquier.estUnCavalier(new Position(7,0), new Position(5,2)));
    }

    @Test
    public void testInvalideGaucheVersBas(){
        assertEquals(false, echiquier.estUnCavalier(new Position(7,0), new Position(9,2)));
    }

    @Test
    public void testInvalideDroiteVersHaut(){
        assertEquals(false, echiquier.estUnCavalier(new Position(7,4), new Position(5,2)));
    }

    @Test
    public void testInvalideDroiteVersBas(){
        assertEquals(false, echiquier.estUnCavalier(new Position(7,4), new Position(9,2)));
    }

    @Test
    public void testValideHaut1(){
        assertEquals(false, echiquier.estUnCavalier(new Position(3,4), new Position(4,4)));
    }

    @Test
    public void testValideHaut8(){
        assertEquals(false, echiquier.estUnCavalier(new Position(0,3), new Position(8,3)));
    }

    @Test
    public void testValideBas1(){
        assertEquals(false, echiquier.estUnCavalier(new Position(6,4), new Position(5,4)));
    }

    @Test
    public void testValideBas8(){
        assertEquals(false, echiquier.estUnCavalier(new Position(9,3), new Position(0,3)));
    }

    @Test
    public void testValideLigneVersLaDroite1(){
        assertEquals(false, echiquier.estUnCavalier(new Position(2,7), new Position(2,8)));
    }
    @Test
    public void testValideLigneVersLaDroite8(){
        assertEquals(false, echiquier.estUnCavalier(new Position(1,0), new Position(1,8)));
    }

    @Test
    public void testValideLigneVersLaGauche1(){
        assertEquals(false, echiquier.estUnCavalier(new Position(2,7), new Position(2,6)));
    }

    @Test
    public void testValideLigneVersLaGauche8(){
        assertEquals(false, echiquier.estUnCavalier(new Position(1,8), new Position(1,0)));
    }
}
