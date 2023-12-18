package testPiece;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xiangqi.piece.Pion;
import xiangqi.piece.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPion {

    Pion noir ;
    Pion rouge ;

    @BeforeEach
    public void beforeEach()
    {
        System.out.println("----------------------- Next Test ---------------------");
        noir = new Pion("cn", "noir");
        rouge = new Pion("pr","rouge");
    }

    @Test
    public void deplacamentValideSurPlace(){
        assertEquals(true, rouge.estValide(new Position(6,4),new Position(6,4)));
    }
    @Test
    public void deplacamentValideAvanceAvantRiviereNoir(){
        assertEquals(true, noir.estValide(new Position(3,2),new Position(4,2)));
    }
    @Test
    public void deplacamentValideAvanceApresRiviereNoir(){
        assertEquals(true, noir.estValide(new Position(5,2),new Position(6,2)));
    }
    @Test
    public void deplacamentValideGaucheApresRiviereNoir(){
        assertEquals(true, noir.estValide(new Position(5,2),new Position(5,1)));
    }
    @Test
    public void deplacamentValideDroiteApresRiviereNoir(){
        assertEquals(true, noir.estValide(new Position(5,2),new Position(5,3)));
    }

    @Test
    public void deplacamentInvalideReculerAvantRiviereNoir(){
        assertEquals(false, noir.estValide(new Position(3,2),new Position(2,2)));
    }

    @Test
    public void deplacamentInvalideGaucheAvantRiviereNoir(){
        assertEquals(false, noir.estValide(new Position(3,2),new Position(3,1)));
    }

    @Test
    public void deplacamentInvalideDroiteAvantRiviereNoir(){
        assertEquals(false, noir.estValide(new Position(3,2),new Position(3,4)));
    }

    @Test
    public void deplacamentInvalideReculerApresRiviereNoir(){
        assertEquals(false, noir.estValide(new Position(5,2),new Position(4,2)));
    }

    @Test
    public void deplacamentInvalideDiagonaleAvantRiviereNoir(){
        assertEquals(false, noir.estValide(new Position(3,2),new Position(4,3)));
    }

    @Test
    public void deplacamentInvalideDiagonaleApresRiviereNoir(){
        assertEquals(false, noir.estValide(new Position(5,2),new Position(6,1)));
    }

    @Test
    public void deplacamentInvalideTropLongNoir(){
        assertEquals(false, noir.estValide(new Position(2,3),new Position(4,3)));
    }



    @Test
    public void deplacamentValideAvanceAvantRiviereRouge(){
        assertEquals(true, rouge.estValide(new Position(6,2),new Position(5,2)));
    }
    @Test
    public void deplacamentValideAvanceApresRiviereRouge(){
        assertEquals(true, rouge.estValide(new Position(4,2),new Position(3,2)));
    }
    @Test
    public void deplacamentValideGaucheApresRiviereRouge(){
        assertEquals(true, rouge.estValide(new Position(4,2),new Position(4,1)));
    }
    @Test
    public void deplacamentValideDroiteApresRiviereRouge(){
        assertEquals(true, rouge.estValide(new Position(4,2),new Position(4,3)));
    }

    @Test
    public void deplacamentInvalideReculerAvantRiviereRouge(){
        assertEquals(false, rouge.estValide(new Position(6,2),new Position(7,2)));
    }

    @Test
    public void deplacamentInvalideGaucheAvantRiviereRouge(){
        assertEquals(false, rouge.estValide(new Position(6,2),new Position(6,1)));
    }

    @Test
    public void deplacamentInvalideDroiteAvantRiviereRouge(){
        assertEquals(false, rouge.estValide(new Position(6,2),new Position(6,3)));
    }

    @Test
    public void deplacamentInvalideReculerApresRiviereRouge(){
        assertEquals(false, rouge.estValide(new Position(4,2),new Position(5,2)));
    }

    @Test
    public void deplacamentInvalideDiagonaleAvantRiviereRouge(){
        assertEquals(false, rouge.estValide(new Position(6,2),new Position(5,3)));
    }

    @Test
    public void deplacamentInvalideDiagonaleApresRiviereRouge(){
        assertEquals(false, rouge.estValide(new Position(4,2),new Position(3,3)));
    }

    @Test
    public void deplacamentInvalideTropLongRouge(){
        assertEquals(false, rouge.estValide(new Position(6,2),new Position(4,2)));
    }

}
