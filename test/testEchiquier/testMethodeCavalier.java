package testEchiquier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xiangqi.echiquier.Echiquier;
import xiangqi.piece.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testMethodeCavalier {


    Echiquier echiquier;

    @BeforeEach
    public void beforeEach()
    {echiquier = new Echiquier();}


    @Test
    public void testCavalierHautGauche(){
        assertEquals(0, echiquier.cheminPossible2(new Position(2,3), new Position(0,2)));
    }

    @Test
    public void testCavalierHautDroite(){
        assertEquals(0, echiquier.cheminPossible2(new Position(2,3), new Position(0,4)));
    }

    @Test
    public void testCavalierBasGauche(){
        assertEquals(0, echiquier.cheminPossible2(new Position(2,3), new Position(4,2)));
    }

    @Test
    public void testCavalierBasDroite(){
        assertEquals(0, echiquier.cheminPossible2(new Position(2,3), new Position(4,4)));
    }

    @Test
    public void testCavalierGaucheHaut(){
        assertEquals(0, echiquier.cheminPossible2(new Position(2,3), new Position(1,1)));
    }

    @Test
    public void testCavalierGaucheDroite(){
        assertEquals(0, echiquier.cheminPossible2(new Position(2,3), new Position(3,1)));
    }

    @Test
    public void testCavalierDroiteHaut(){
        assertEquals(0, echiquier.cheminPossible2(new Position(2,3), new Position(1,5)));
    }

    @Test
    public void testCavalierDroiteBas(){
        //increment/ seulement l<horizontale OU le verticale, pas les deux
        assertEquals(0, echiquier.cheminPossible2(new Position(2,3), new Position(3,5)));
    }
}
