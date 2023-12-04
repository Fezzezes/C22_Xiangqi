import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xiangqi.Elephant;
import xiangqi.Position;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestElephant {

    Elephant noir ;
    Elephant rouge;

    @BeforeEach
    public void beforeEach()
    {
        System.out.println("----------------------- Next Test ---------------------");
        noir = new Elephant("en", "noir");
        rouge = new Elephant("er", "rouge");
    }

    @Test
    public void deplacamentValideSurPlaceNoir(){
        assertEquals(true, noir.estValide(new Position(0,2),new Position(0,2)));
    }

    @Test
    public void deplacamentValideEnDiagonaleGaucheNoir(){
        assertEquals(true, noir.estValide(new Position(0,2),new Position(2,0)));
    }

    @Test
    public void deplacamentValideEnDiagonaleDroiteNoir(){
        assertEquals(true, noir.estValide(new Position(0,2),new Position(2,4)));
    }

    @Test
    public void deplacamentInvalideTraverseRivièreNoir(){
        assertEquals(false, noir.estValide(new Position(4,2),new Position(6,4)));
    }

    @Test
    public void deplacamentInvalideHorizontalNoir(){
        assertEquals(false, noir.estValide(new Position(0,2),new Position(0,4)));
    }
    @Test
    public void deplacamentInvalideVerticalNoir(){
        assertEquals(false, noir.estValide(new Position(4,6),new Position(2,6)));
    }
    @Test
    public void deplacamentInvalideTropCourtNoir(){
        assertEquals(false, noir.estValide(new Position(0,6),new Position(1,5)));
    }
    @Test
    public void deplacamentInvalideTropLongNoir(){
        assertEquals(false, noir.estValide(new Position(0,6),new Position(3,3)));
    }


    @Test
    public void deplacamentValideEnDiagonalGaucheRouge(){
        assertEquals(true, rouge.estValide(new Position(9,2),new Position(7,0)));
    }

    @Test
    public void deplacamentValideEnDiagonalDroiteRouge(){
        assertEquals(true, rouge.estValide(new Position(9,2),new Position(7,4)));
    }

    @Test
    public void deplacamentInvalideTraverseRivièreRouge(){
        assertEquals(false, rouge.estValide(new Position(5,2),new Position(3,4)));
    }

}
