package testEchiquier;
import org.junit.jupiter.api.BeforeAll;

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
//        @Test
//        public void testValideLigneVersLaDroite1(){
//            assertEquals(0, echiquier.pieceSurLaligne(new Position(2,7), new Position(2,8)));
//        }
//        @Test
//        public void testValideLigneVersLaDroite8(){
//            assertEquals(0, echiquier.pieceSurLaligne(new Position(1,0), new Position(1,8)));
//        }
//
//        @Test
//        public void testValideLigneVersLaGauche1(){
//            assertEquals(0, echiquier.pieceSurLaligne(new Position(2,7), new Position(2,6)));
//        }
//
//        @Test
//        public void testValideLigneVersLaGauche8(){
//            assertEquals(0, echiquier.pieceSurLaligne(new Position(1,8), new Position(1,0)));
//        }
//
//
//        @Test
//        public void testInvalideLigneVersLaDroite8(){
//            assertEquals(7, echiquier.pieceSurLaligne(new Position(0,0), new Position(0,8)));
//        }
//
//
//        @Test
//        public void testInvalideLigneVersLaGauche8(){
//            assertEquals(7, echiquier.pieceSurLaligne(new Position(0,8), new Position(0,0)));
//        }
//
//
//        @Test
//        public void testInvalideBlockeParEnnemi(){
//            echiquier.getJeu()[2][4].setPiece(new Bombarde("B","rouge"));
//            assertEquals(1, echiquier.pieceSurLaligne(new Position(2,1), new Position(2,6)));
//        }
//
//        @Test
//        public void testInvalideBlockeParAmi(){
//            echiquier.getJeu()[2][4].setPiece(new Bombarde("B","noir"));
//            assertEquals(1, echiquier.pieceSurLaligne(new Position(2,1), new Position(2,6)));
//        }


        // ------------------- chemin 2

        @Test
        public void testValideLigneVersLaDroite1(){
            assertEquals(true, echiquier.cheminPossible(new Position(2,7), new Position(2,8)));
        }
        @Test
        public void testValideLigneVersLaDroite8(){
            assertEquals(true, echiquier.cheminPossible(new Position(1,0), new Position(1,8)));
        }

        @Test
        public void testValideLigneVersLaGauche1(){
            assertEquals(true, echiquier.cheminPossible(new Position(2,7), new Position(2,6)));
        }

        @Test
        public void testValideLigneVersLaGauche8(){
            assertEquals(true, echiquier.cheminPossible(new Position(1,8), new Position(1,0)));
        }

        @Test
        public void testValideLigneVersLaGauche8SurEnnemi(){
            echiquier.getJeu()[1][8].setPiece(new Bombarde("B","noir"));
            echiquier.getJeu()[1][0].setPiece(new Bombarde("B","rouge"));
            assertEquals(true, echiquier.cheminPossible(new Position(1,8), new Position(1,0)));
        }

        @Test
        public void testValideLigneVersLaDroite8SurEnnemi(){
            echiquier.getJeu()[1][0].setPiece(new Bombarde("B","noir"));
            echiquier.getJeu()[1][8].setPiece(new Bombarde("B","rouge"));
            assertEquals(true, echiquier.cheminPossible(new Position(1,0), new Position(1,8)));
        }


        @Test
        public void testInvalideLigneVersLaDroite8(){
            assertEquals(false, echiquier.cheminPossible(new Position(0,0), new Position(0,8)));
        }


        @Test
        public void testInvalideLigneVersLaGauche8(){
            assertEquals(false, echiquier.cheminPossible(new Position(0,8), new Position(0,0)));
        }


        @Test
        public void testInvalideBlockeParEnnemi(){
            echiquier.getJeu()[2][4].setPiece(new Bombarde("B","rouge"));
            assertEquals(false, echiquier.cheminPossible(new Position(2,1), new Position(2,6)));
        }

        @Test
        public void testInvalideBlockeParAmi(){
            echiquier.getJeu()[2][4].setPiece(new Bombarde("B","noir"));
            assertEquals(false, echiquier.cheminPossible(new Position(2,1), new Position(2,6)));
        }

        @Test
        public void testInvalideLigneVersLaGauche8SurAmi(){
            echiquier.getJeu()[1][8].setPiece(new Bombarde("B","noir"));
            echiquier.getJeu()[1][0].setPiece(new Bombarde("B","noir"));
            assertEquals(false, echiquier.cheminPossible(new Position(1,8), new Position(1,0)));
        }

        @Test
        public void testInvalideLigneVersLaDroite8SurAmi(){
            echiquier.getJeu()[1][0].setPiece(new Bombarde("B","rouge"));
            echiquier.getJeu()[1][8].setPiece(new Bombarde("B","rouge"));
            assertEquals(false, echiquier.cheminPossible(new Position(1,0), new Position(1,8)));
        }


}
