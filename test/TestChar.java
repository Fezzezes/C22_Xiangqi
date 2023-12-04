import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xiangqi.Char;
import xiangqi.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestChar {

    Char noir ;

    @BeforeEach
    public void beforeEach()
    {
        System.out.println("----------------------- Next Test ---------------------");
        noir = new Char("cn", "noir");
    }

    @Test
    public void deplacamentValideSurPlace(){
        assertEquals(true, noir.estValide(new Position(9,8),new Position(9,8)));
    }

    @Test
    public void deplacamentValideHorizontalLong(){
        assertEquals(true, noir.estValide(new Position(9,8),new Position(9,0)));
    }

    @Test
    public void deplacamentValideVerticalLong(){
        assertEquals(true, noir.estValide(new Position(9,8),new Position(0,8)));
    }

    @Test
    public void deplacamentValideHorizontalCourt(){
        assertEquals(true, noir.estValide(new Position(9,8),new Position(9,7)));
    }

    @Test
    public void deplacamentValideVerticalCourt(){
        assertEquals(true, noir.estValide(new Position(9,8),new Position(8,8)));
    }

    @Test
    public void deplacamentInvalideDiagonale(){
        assertEquals(false, noir.estValide(new Position(9,8),new Position(8,7)));
    }

    @Test
    public void deplacamentInvalideAutre1Aleatoire(){
        assertEquals(false, noir.estValide(new Position(9,8),new Position(6,2)));
    }

    @Test
    public void deplacamentInvalideAutre2Aleatoire(){
        assertEquals(false, noir.estValide(new Position(9,8),new Position(2,6)));
    }


}
