package testEchiquier;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import xiangqi.echiquier.Echiquier;
import xiangqi.piece.Bombarde;
import xiangqi.piece.Char;
import xiangqi.piece.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;


    public class testMethodeLigne {

        static Echiquier echiquier;

        @BeforeEach
        public void beforeEach(){
            echiquier = new Echiquier();
        }

        @AfterEach
        public  void afterEach(){
            System.out.println("");
            echiquier.afficher();
        }


        //Chemin Ligne droite --------------------------------------------------------------------

        @Test
        public void testValideDeplacementNULL(){
            echiquier.getJeu()[2][7].setPiece(new Char("!","noir"));
            assertEquals(true, echiquier.cheminPossible(new Position(2,7), new Position(2,7)));
        }

        @Test
        public void testValideLigneVersLaDroite1(){
            echiquier.getJeu()[2][7].setPiece(new Char("!","noir"));
            assertEquals(true, echiquier.cheminPossible(new Position(2,7), new Position(2,8)));
        }
        @Test
        public void testValideLigneVersLaDroite8(){
            echiquier.getJeu()[1][0].setPiece(new Char("!","noir"));
            assertEquals(true, echiquier.cheminPossible(new Position(1,0), new Position(1,8)));
        }

        @Test
        public void testValideLigneVersLaGauche1(){
            echiquier.getJeu()[2][7].setPiece(new Char("!","noir"));
            assertEquals(true, echiquier.cheminPossible(new Position(2,7), new Position(2,6)));
        }

        @Test
        public void testValideLigneVersLaGauche8(){
            echiquier.getJeu()[1][8].setPiece(new Char("!","noir"));
            assertEquals(true, echiquier.cheminPossible(new Position(1,8), new Position(1,0)));
        }

        @Test
        public void testValideLigneVersLaGauche8SurEnnemi(){
            echiquier.getJeu()[1][8].setPiece(new Char("!","noir"));
            echiquier.getJeu()[1][0].setPiece(new Bombarde("?","rouge"));
            assertEquals(true, echiquier.cheminPossible(new Position(1,8), new Position(1,0)));
        }

        @Test
        public void testValideLigneVersLaDroite8SurEnnemi(){
            echiquier.getJeu()[1][0].setPiece(new Char("!","noir"));
            echiquier.getJeu()[1][8].setPiece(new Bombarde("?","rouge"));
            assertEquals(true, echiquier.cheminPossible(new Position(1,0), new Position(1,8)));
        }


        @Test
        public void testInvalideLigneVersLaDroite8(){
            echiquier.debuter();
            echiquier.getJeu()[0][0].setPiece(new Char("!","noir"));
            echiquier.getJeu()[0][8].setPiece(new Char("?","noir"));
            assertEquals(false, echiquier.cheminPossible(new Position(0,0), new Position(0,8)));
        }


        @Test
        public void testInvalideLigneVersLaGauche8(){
            echiquier.debuter();
            echiquier.getJeu()[0][8].setPiece(new Char("!","noir"));
            echiquier.getJeu()[0][0].setPiece(new Char("?","noir"));
            assertEquals(false, echiquier.cheminPossible(new Position(0,8), new Position(0,0)));
        }


        @Test
        public void testInvalideBlockeParEnnemi(){
            echiquier.getJeu()[2][1].setPiece(new Char("!","noir"));
            echiquier.getJeu()[2][4].setPiece(new Bombarde("B","rouge"));
            echiquier.getJeu()[2][6].setPiece(null);
            assertEquals(false, echiquier.cheminPossible(new Position(2,1), new Position(2,6)));
        }

        @Test
        public void testInvalideBlockeParAmi(){
            echiquier.getJeu()[2][1].setPiece(new Char("!","noir"));
            echiquier.getJeu()[2][4].setPiece(new Bombarde("B","noir"));
            echiquier.getJeu()[2][6].setPiece(null);
            assertEquals(false, echiquier.cheminPossible(new Position(2,1), new Position(2,6)));
        }

        @Test
        public void testInvalideLigneVersLaGauche8SurAmi(){
            echiquier.getJeu()[1][8].setPiece(new Char("!","noir"));
            echiquier.getJeu()[1][0].setPiece(new Bombarde("?","noir"));
            assertEquals(false, echiquier.cheminPossible(new Position(1,8), new Position(1,0)));
        }

        @Test
        public void testInvalideLigneVersLaDroite8SurAmi(){
            echiquier.getJeu()[1][0].setPiece(new Char("!","rouge"));
            echiquier.getJeu()[1][8].setPiece(new Bombarde("?","rouge"));
            assertEquals(false, echiquier.cheminPossible(new Position(1,0), new Position(1,8)));
        }


}
