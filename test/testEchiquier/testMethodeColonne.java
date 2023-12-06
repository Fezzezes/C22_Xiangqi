package testEchiquier;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import xiangqi.echiquier.Echiquier;
import xiangqi.piece.Bombarde;
import xiangqi.piece.Position;


public class testMethodeColonne {

        static Echiquier echiquier;

        @BeforeAll
        public static void beforeAll() {
            echiquier = new Echiquier();
            echiquier.afficher();
        }

        @BeforeEach
        public void beforeEach()
        {echiquier = new Echiquier();}


        //Chemin Ligne droite --------------------------------------------------------------------
        @Test
        public void testValideHaut1(){
            assertEquals(0, echiquier.pieceSurLaColonne(new Position(3,4), new Position(4,4)));
        }

        @Test
        public void testValideHaut8(){
            assertEquals(0, echiquier.pieceSurLaColonne(new Position(0,3), new Position(8,3)));
        }

        @Test
        public void testValideBas1(){
            assertEquals(0, echiquier.pieceSurLaColonne(new Position(6,4), new Position(5,4)));
        }

        @Test
        public void testValideBas8(){
            assertEquals(0, echiquier.pieceSurLaColonne(new Position(3,9), new Position(3,1)));
        }


        @Test
        public void testInvalideHaut9(){
            assertEquals(2, echiquier.pieceSurLaColonne(new Position(0,0), new Position(9,0)));
        }

        @Test
        public void testInvalideBas9(){
            assertEquals(2, echiquier.pieceSurLaColonne(new Position(9,0), new Position(0,0)));
        }

        @Test
        public void testInvalideBlockeParEnnemi(){
            echiquier.getJeu()[7][3].setPiece(new Bombarde("B","noir"));
            assertEquals(1, echiquier.pieceSurLaColonne(new Position(9,3), new Position(0,3)));
        }

        @Test
        public void testInvalideBlockeParAmi(){
            echiquier.getJeu()[7][3].setPiece(new Bombarde("B","rouge"));
            assertEquals(1, echiquier.pieceSurLaColonne(new Position(9,3), new Position(0,3)));
        }



}
