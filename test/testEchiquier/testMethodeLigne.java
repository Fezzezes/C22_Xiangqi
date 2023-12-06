package testEchiquier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xiangqi.echiquier.Echiquier;
import xiangqi.piece.Bombarde;
import xiangqi.piece.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;


    public class testMethodeLigne {

        static Echiquier echiquier;

        @BeforeAll
        public static void beforeAll(){
            echiquier = new Echiquier();
        }

//        @BeforeEach
//        public void beforeEach()
//        {}

        //Chemin Ligne droite --------------------------------------------------------------------
        @Test
        public void testValideLigneVersLaGauche1(){
            assertEquals(true, echiquier.cheminPossible(new Position(2,7), new Position(2,8)));
        }
        @Test
        public void testValideLigneVersLaGauche9(){
            assertEquals(true, echiquier.cheminPossible(new Position(1,0), new Position(1,8)));
        }

        @Test
        public void testValideLigneVersLaDroite1(){
            assertEquals(true, echiquier.cheminPossible(new Position(2,7), new Position(2,6)));
        }

        @Test
        public void testValideLigneVersLaDroite9(){
            assertEquals(true, echiquier.cheminPossible(new Position(1,8), new Position(1,0)));
        }

        @Test
        public void testValideLigneVersLaGaucheSurUnEnnemi(){

            echiquier.getJeu()[2][8].setPiece(new Bombarde("B","rouge"));

            assertEquals(true, echiquier.cheminPossible(new Position(2,8), new Position(2,7)));
        }

        @Test
        public void testValideLigneVersLaDroiteSurUnEnnemi(){
            echiquier.getJeu()[7][8].setPiece(new Bombarde("B","noir"));
            assertEquals(true, echiquier.cheminPossible(new Position(7,7), new Position(7,8)));
        }



        @Test
        public void testInvalideLigneVersLaGauche1(){
            assertEquals(false, echiquier.cheminPossible(new Position(0,8), new Position(0,7)));
        }
        @Test
        public void testInvalideLigneVersLaGauche9(){
            assertEquals(false, echiquier.cheminPossible(new Position(0,8), new Position(0,0)));
        }

        @Test
        public void testInvalideLigneVersLaDroite1(){
            assertEquals(false, echiquier.cheminPossible(new Position(0,0), new Position(0,1)));
        }

        @Test
        public void testInvalideLigneVersLaDroite9(){
            assertEquals(false, echiquier.cheminPossible(new Position(0,0), new Position(0,8)));
        }
}
