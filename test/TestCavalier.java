import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xiangqi.Cavalier;
import xiangqi.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCavalier {

    Cavalier noir ;

    @BeforeEach
    public void beforeEach()
    {
        System.out.println("----------------------- Next Test ---------------------");
        noir = new Cavalier("cn", "noir");
    }

    @Test
    public void deplacamentValideSurPlaceNoir(){
        assertEquals(true, noir.estValide(new Position(0,2),new Position(0,2)));
    }

    @Test
    public void deplacamentValideGaucheHaut(){
        assertEquals(true, noir.estValide(new Position(2,4),new Position(1,2)));
    }

    @Test
    public void deplacamentValideGaucheBas(){
        assertEquals(true, noir.estValide(new Position(2,4),new Position(3,2)));
    }

    @Test
    public void deplacamentValideDroiteHaut(){
        assertEquals(true, noir.estValide(new Position(2,4),new Position(1,6)));
    }

    @Test
    public void deplacamentValideDroiteBas(){
        assertEquals(true, noir.estValide(new Position(2,4),new Position(3,6)));
    }

    @Test
    public void deplacamentValideHautGauche(){
        assertEquals(true, noir.estValide(new Position(2,4),new Position(0,3)));
    }

    @Test
    public void deplacamentValideHautDroite(){
        assertEquals(true, noir.estValide(new Position(2,4),new Position(0,5)));
    }

    @Test
    public void deplacamentValideBasGauche(){
        assertEquals(true, noir.estValide(new Position(2,4),new Position(4,3)));
    }

    @Test
    public void deplacamentValideBasDroit(){
        assertEquals(true, noir.estValide(new Position(2,4),new Position(4,5)));
    }


    @Test
    public void deplacamentInvalideHorizontal(){
        assertEquals(false, noir.estValide(new Position(2,4),new Position(2,6)));
    }

    @Test
    public void deplacamentInvalideVertical(){
        assertEquals(false, noir.estValide(new Position(2,4),new Position(0,4)));
    }

    @Test
    public void deplacamentInvalideTropLong(){
        assertEquals(false, noir.estValide(new Position(2,4),new Position(0,7)));
    }

    @Test
    public void deplacamentInvalideTropCourt(){
        assertEquals(false, noir.estValide(new Position(2,4),new Position(2,5)));
    }

    @Test
    public void deplacamentInvalideDiagonal(){
        assertEquals(false, noir.estValide(new Position(2,4),new Position(3,5)));
    }



}
