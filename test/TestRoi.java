import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import xiangqi.Position;
import xiangqi.Roi;

public class TestRoi {

    Roi roiNoir ;
    Roi roiRouge;

    @BeforeEach
    public void beforeEach()
    {
        System.out.println("----------------------- Next Test ---------------------");
        roiNoir = new Roi("rn", "noir");
        roiRouge = new Roi("rr", "rouge");
    }

    @Test
    public void deplacamentValideSurPlace(){
        assertEquals(true, roiNoir.estValide(new Position(1,4),new Position(1,4)));
    }
    @Test
    public void deplacamentValideHorizontalDansPalaisNoir(){
        assertEquals(true, roiNoir.estValide(new Position(1,4),new Position(1,5)));
    }

    @Test
    public void deplacamentValideVerticalDansPalaisNoir(){
        assertEquals(true, roiNoir.estValide(new Position(1,4),new Position(0,4)));
    }

    @Test
    public void deplacamentInvalideHorizontalHorsPalaisNoir(){
        assertEquals(false, roiNoir.estValide(new Position(0,3),new Position(0,2)));
    }

    @Test
    public void deplacamentInvalideVerticalHorsPalaisNoir(){
        assertEquals(false, roiNoir.estValide(new Position(2,3),new Position(3,3)));
    }

    @Test
    public void deplacamentInvalideTropLongDansPalaisNoir(){
        assertEquals(false, roiNoir.estValide(new Position(0,3),new Position(0,5)));
    }

    @Test
    public void deplacamentInvalideDiagonaleDansPalaisNoir(){
        assertEquals(false, roiNoir.estValide(new Position(1,4),new Position(2,5)));
    }

    @Test
    public void deplacamentValideHorizontalDansPalaisRouge(){
        assertEquals(true, roiRouge.estValide(new Position(8,4),new Position(8,3)));
    }

    @Test
    public void deplacamentValideVerticalDansPalaisRouge(){
        assertEquals(true, roiRouge.estValide(new Position(8,4),new Position(9,4)));
    }

    @Test
    public void deplacamentInvalideHorizontalHorsPalaisRouge(){
        assertEquals(false, roiRouge.estValide(new Position(9,5),new Position(9,6)));
    }

    @Test
    public void deplacamentInvalideVerticalHorsPalaisRouge(){
        assertEquals(false, roiRouge.estValide(new Position(7,3),new Position(6,3)));
    }

    @Test
    public void deplacamentInvalideTropLongDansPalaisRouge(){
        assertEquals(false, roiRouge.estValide(new Position(7,3),new Position(7,5)));
    }

    @Test
    public void deplacamentInvalideDiagonaleDansPalaisRouge(){
        assertEquals(false, roiRouge.estValide(new Position(8,4),new Position(7,3)));
    }



}
