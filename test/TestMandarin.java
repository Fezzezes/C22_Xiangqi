import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xiangqi.Mandarin;
import xiangqi.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMandarin {

    Mandarin noir ;
    Mandarin rouge;

    @BeforeEach
    public void beforeEach()
    {
        System.out.println("----------------------- Next Test ---------------------");
        noir = new Mandarin("mn", "noir");
        rouge = new Mandarin("mr", "rouge");
    }

    @Test
    public void deplacamentValideSurPlace(){
        assertEquals(true, noir.estValide(new Position(1,4),new Position(1,4)));
    }
    @Test
    public void deplacamentValideDiagonaleDansPalaisNoir(){
        assertEquals(true, noir.estValide(new Position(1,4),new Position(0,3)));
    }

    @Test
    public void deplacamentInvalideHorizontalDansPalaisNoir(){
        assertEquals(false, noir.estValide(new Position(1,4),new Position(1,5)));
    }

    @Test
    public void deplacamentInvalideVerticalDansPalaisNoir(){
        assertEquals(false, noir.estValide(new Position(1,4),new Position(0,4)));
    }

    @Test
    public void deplacamentInvalideDiagonaleHorsPalaisNoir(){
        assertEquals(false, noir.estValide(new Position(2,3),new Position(3,2)));
    }

    @Test
    public void deplacamentInvalideTropLongDansPalaisNoir(){
        assertEquals(false, noir.estValide(new Position(0,5),new Position(2,3)));
    }

    @Test
    public void deplacamentValideDiagonaleDansPalaisRouge(){
        assertEquals(true, rouge.estValide(new Position(8,4),new Position(7,3)));
    }

    @Test
    public void deplacamentInvalideHorizontalDansPalaisRouge(){
        assertEquals(false, rouge.estValide(new Position(8,3),new Position(8,4)));
    }

    @Test
    public void deplacamentInvalideVerticalDansPalaisRouge(){
        assertEquals(false, rouge.estValide(new Position(8,4),new Position(7,4)));
    }

    @Test
    public void deplacamentInvalideDiagonaleHorsPalaisRouge(){
        assertEquals(false, rouge.estValide(new Position(7,3),new Position(2,6)));
    }

    @Test
    public void deplacamentInvalideTropLongDansPalaisRouge(){
        assertEquals(false, rouge.estValide(new Position(7,3),new Position(5,9)));
    }

}
