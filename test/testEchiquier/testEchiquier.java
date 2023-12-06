package testEchiquier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xiangqi.echiquier.Echiquier;
import xiangqi.piece.Bombarde;
import xiangqi.piece.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testEchiquier {

    Echiquier echiquier;

    @BeforeEach
    public void beforeEach()
    {echiquier = new Echiquier();}

    @Test
    public void constructeur(){
    }

    @Test
    public void testValideSurUnAmi(){
        echiquier.getJeu()[2][8].setPiece(new Bombarde("B","noir"));
        assertEquals(true, echiquier.estOccupeParAmi(new Position(2,8), new Position(2,7)));
    }

    @Test
    public void testInvalideSurUnEnnemi(){
        assertEquals(false, echiquier.estOccupeParAmi(new Position(0,3), new Position(9,3)));
    }



}
