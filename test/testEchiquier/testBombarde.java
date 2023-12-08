package testEchiquier;

import org.junit.jupiter.api.*;
import xiangqi.echiquier.Echiquier;
import xiangqi.piece.Bombarde;
import xiangqi.piece.Cavalier;
import xiangqi.piece.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testBombarde {

    Echiquier echiquier;

    @BeforeEach
    public void beforeEach() {
        echiquier = new Echiquier();
    }

    @AfterEach
    public void afterEach() {
        System.out.println("");
        echiquier.afficher();
    }

    //--- Valide déplacement comme une tour sans capture
    @Test
    public void testValideDeplacementBas1() {
        echiquier.getJeu()[3][4].setPiece(new Bombarde("!", "noir"));
        assertEquals(true, echiquier.cheminPossible(new Position(3, 4), new Position(4, 4)));
    }

    @Test
    public void testValideDeplacementBas8() {
        echiquier.getJeu()[0][3].setPiece(new Bombarde("!", "noir"));
        assertEquals(true, echiquier.cheminPossible(new Position(0, 3), new Position(8, 3)));
    }

    @Test
    public void testValideDeplacementHaut1() {
        echiquier.getJeu()[6][4].setPiece(new Bombarde("!", "noir"));
        assertEquals(true, echiquier.cheminPossible(new Position(6, 4), new Position(5, 4)));
    }

    @Test
    public void testValideDeplacementHaut8() {
        echiquier.getJeu()[9][3].setPiece(new Bombarde("!", "noir"));
        assertEquals(true, echiquier.cheminPossible(new Position(9, 3), new Position(1, 3)));
    }

    @Test
    public void testValideDeplacementDroite1() {
        echiquier.getJeu()[2][7].setPiece(new Bombarde("!", "rouge"));
        assertEquals(true, echiquier.cheminPossible(new Position(2, 7), new Position(2, 8)));
    }

    @Test
    public void testValideDeplacementDroite8() {
        echiquier.getJeu()[1][0].setPiece(new Bombarde("!", "rouge"));
        assertEquals(true, echiquier.cheminPossible(new Position(1, 0), new Position(1, 8)));
    }

    @Test
    public void testValideDeplacementaGauche1() {
        echiquier.getJeu()[2][7].setPiece(new Bombarde("!", "rouge"));
        assertEquals(true, echiquier.cheminPossible(new Position(2, 7), new Position(2, 6)));
    }

    @Test
    public void testValideDeplacementaGauche8() {
        echiquier.getJeu()[1][8].setPiece(new Bombarde("!", "rouge"));
        assertEquals(true, echiquier.cheminPossible(new Position(1, 8), new Position(1, 0)));
    }
//--- valide capture d'un ennemi avec une pièce qui bloque
    @Test
    public void testValideBasCaptureEnnemi() {
        echiquier.getJeu()[0][0].setPiece(new Bombarde("!", "noir"));
        echiquier.getJeu()[5][0].setPiece(new Bombarde("X", "rouge"));
        echiquier.getJeu()[9][0].setPiece(new Bombarde("X", "rouge"));
        assertEquals(true, echiquier.cheminPossible(new Position(0, 0), new Position(9, 0)));
    }

    @Test
    public void testValideHautCaptureEnnemi() {
        echiquier.getJeu()[9][0].setPiece(new Bombarde("!", "noir"));
        echiquier.getJeu()[5][0].setPiece(new Bombarde("X", "noir"));
        echiquier.getJeu()[0][0].setPiece(new Bombarde("X", "rouge"));
        assertEquals(true, echiquier.cheminPossible(new Position(9, 0), new Position(0, 0)));
    }

    @Test
    public void testValideDroiteCaptureEnnemi() {
        echiquier.getJeu()[1][0].setPiece(new Bombarde("!", "rouge"));
        echiquier.getJeu()[1][7].setPiece(new Bombarde("X", "rouge"));
        echiquier.getJeu()[1][8].setPiece(new Bombarde("?", "noir"));
        assertEquals(true, echiquier.cheminPossible(new Position(1, 0), new Position(1, 8)));
    }

    @Test
    public void testValideGaucheCaptureEnnemi() {
        echiquier.getJeu()[1][8].setPiece(new Bombarde("!", "rouge"));
        echiquier.getJeu()[1][4].setPiece(new Bombarde("X", "noir"));
        echiquier.getJeu()[1][0].setPiece(new Bombarde("?", "noir"));
        assertEquals(true, echiquier.cheminPossible(new Position(1, 8), new Position(1, 0)));
    }

//--- Invalide deplacement bloquer

    @Test
    public void testInvalideDeplacementBas8Bloque() {
        echiquier.getJeu()[0][0].setPiece(new Bombarde("!", "noir"));
        echiquier.getJeu()[6][0].setPiece(new Bombarde("X", "noir"));
        assertEquals(false, echiquier.cheminPossible(new Position(0, 0), new Position(9, 0)));
    }

    @Test
    public void testInValideDeplacementHaut8Bloque() {
        echiquier.getJeu()[9][0].setPiece(new Bombarde("!", "noir"));
        echiquier.getJeu()[6][0].setPiece(new Bombarde("X", "rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(9, 0), new Position(0, 0)));
    }

    @Test
    public void testInvalideDeplacementDroite8Bloque() {
        echiquier.getJeu()[1][0].setPiece(new Bombarde("!", "rouge"));
        echiquier.getJeu()[1][6].setPiece(new Bombarde("X", "noir"));
        assertEquals(false, echiquier.cheminPossible(new Position(1, 0), new Position(1, 8)));
    }

    @Test
    public void testInvalideDeplacementGauche8Bloque() {
        echiquier.getJeu()[1][8].setPiece(new Bombarde("!", "rouge"));
        echiquier.getJeu()[1][0].setPiece(new Bombarde("?", "noir"));
        assertEquals(false, echiquier.cheminPossible(new Position(1, 8), new Position(1, 0)));
    }

//-- Invalide capture sans bloque

    @Test
    public void testInvalideCaptureBas8SansBloque() {
        echiquier.getJeu()[0][0].setPiece(new Bombarde("!", "noir"));
        echiquier.getJeu()[9][0].setPiece(new Bombarde("?", "rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(0, 0), new Position(9, 0)));
    }

    @Test
    public void testInvalideCaptureHaut8SansBloque() {
        echiquier.getJeu()[9][0].setPiece(new Bombarde("!", "noir"));
        echiquier.getJeu()[0][0].setPiece(new Bombarde("?", "rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(9, 0), new Position(0, 0)));
    }

    @Test
    public void testInvalideCaptureDroite8SansBloque() {
        echiquier.getJeu()[1][0].setPiece(new Bombarde("!", "rouge"));
        echiquier.getJeu()[1][8].setPiece(new Bombarde("?", "noir"));
        assertEquals(false, echiquier.cheminPossible(new Position(1, 0), new Position(1, 8)));
    }

    @Test
    public void testInvalideCaptureaGauche8SansBloque() {
        echiquier.getJeu()[1][8].setPiece(new Bombarde("!", "rouge"));
        echiquier.getJeu()[1][0].setPiece(new Bombarde("?", "noir"));
        assertEquals(false, echiquier.cheminPossible(new Position(1, 8), new Position(1, 0)));
    }
//--- Invalide capture avec 2 bloque

    @Test
    public void testInvalideCaptureBasBloque() {
        echiquier.getJeu()[0][0].setPiece(new Bombarde("!", "noir"));
        echiquier.getJeu()[4][0].setPiece(new Bombarde("X", "noir"));
        echiquier.getJeu()[5][0].setPiece(new Bombarde("X", "noir"));
        echiquier.getJeu()[9][0].setPiece(new Bombarde("?", "rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(0, 0), new Position(9, 0)));
    }

    @Test
    public void testInvalideCaptureHautBloque() {
        echiquier.getJeu()[9][0].setPiece(new Bombarde("!", "noir"));
        echiquier.getJeu()[5][0].setPiece(new Bombarde("X", "noir"));
        echiquier.getJeu()[4][0].setPiece(new Bombarde("X", "noir"));
        echiquier.getJeu()[0][0].setPiece(new Bombarde("?", "rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(9, 0), new Position(0, 0)));
    }

    @Test
    public void testInvalideCaptureDroiteBloque() {
        echiquier.getJeu()[1][0].setPiece(new Bombarde("!", "rouge"));
        echiquier.getJeu()[1][4].setPiece(new Bombarde("X", "noir"));
        echiquier.getJeu()[1][5].setPiece(new Bombarde("X", "noir"));
        echiquier.getJeu()[1][8].setPiece(new Bombarde("?", "noir"));
        assertEquals(false, echiquier.cheminPossible(new Position(1, 0), new Position(1, 8)));
    }

    @Test
    public void testInvalideCaptureaGaucheBloque() {
        echiquier.getJeu()[1][8].setPiece(new Bombarde("!", "rouge"));
        echiquier.getJeu()[1][4].setPiece(new Bombarde("X", "noir"));
        echiquier.getJeu()[1][5].setPiece(new Bombarde("X", "noir"));
        echiquier.getJeu()[1][0].setPiece(new Bombarde("?", "noir"));
        assertEquals(false, echiquier.cheminPossible(new Position(1, 8), new Position(1, 0)));
    }

//--- Invalide capture un ami
    @Test
    public void testInvalideBasCaptureAmi() {
        echiquier.getJeu()[0][0].setPiece(new Bombarde("!", "noir"));
        echiquier.getJeu()[5][0].setPiece(new Bombarde("X", "rouge"));
        echiquier.getJeu()[9][0].setPiece(new Bombarde("?", "noir"));
        assertEquals(false, echiquier.cheminPossible(new Position(0, 0), new Position(9, 0)));
    }

    @Test
    public void testInvalideHautCaptureAmi() {
        echiquier.getJeu()[9][0].setPiece(new Bombarde("!", "noir"));
        echiquier.getJeu()[5][0].setPiece(new Bombarde("X", "noir"));
        echiquier.getJeu()[0][0].setPiece(new Bombarde("?", "noir"));
        assertEquals(false, echiquier.cheminPossible(new Position(9, 0), new Position(0, 0)));
    }

    @Test
    public void testInvalideDroiteCaptureAmi() {
        echiquier.getJeu()[1][0].setPiece(new Bombarde("!", "rouge"));
        echiquier.getJeu()[1][7].setPiece(new Bombarde("X", "rouge"));
        echiquier.getJeu()[1][8].setPiece(new Bombarde("?", "rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(1, 0), new Position(1, 8)));
    }

    @Test
    public void testInvalideGaucheCaptureAmi() {
        echiquier.getJeu()[1][8].setPiece(new Bombarde("!", "rouge"));
        echiquier.getJeu()[1][4].setPiece(new Bombarde("X", "noir"));
        echiquier.getJeu()[1][0].setPiece(new Bombarde("?", "rouge"));
        assertEquals(false, echiquier.cheminPossible(new Position(1, 8), new Position(1, 0)));
    }
}



