package testEchiquier;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xiangqi.echiquier.Echiquier;
import xiangqi.piece.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testRoiFaceAFace {

    Echiquier echiquier;
    Roi roiNoir;
    Roi roiRouge;
    Pion pion;

    @BeforeEach
    public void beforeEach() {
        echiquier = new Echiquier();
        roiNoir = new Roi("R","noir");
        roiRouge = new Roi("R","rouge");
        pion = new Pion("!","noir");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("");
        echiquier.afficher();
    }

    @Test
    public void testValide2PiecesEntreRoi(){
        //le pion peut bouger, car il y a un pion entre les 2 rois
        echiquier.getJeu()[0][4].setPiece(roiNoir);
        echiquier.getJeu()[4][4].setPiece(pion);
        echiquier.getJeu()[5][4].setPiece(new Pion("X","rouge"));
        echiquier.getJeu()[9][4].setPiece(roiRouge);
        assertEquals(true, echiquier.roisNePouvantPasEtreFaceAFace(new Position(4,4), new Position(4,5)));
    }

    @Test
    public void testValide2PiecesEntreRoiPionDansPalaisRouge(){
        //le pion peut bouger, car il y a un pion entre les 2 rois
        echiquier.getJeu()[0][4].setPiece(roiNoir);
        echiquier.getJeu()[4][4].setPiece(pion);
        echiquier.getJeu()[8][4].setPiece(new Pion("P","rouge"));
        echiquier.getJeu()[9][4].setPiece(roiRouge);
        assertEquals(true, echiquier.roisNePouvantPasEtreFaceAFace(new Position(4,4), new Position(4,5)));
    }

    @Test
    public void testValide2PiecesEntreRoiPionDansPalaisNoir(){
        //le pion peut bouger, car il y a un pion entre les 2 rois
        echiquier.getJeu()[0][4].setPiece(roiNoir);
        echiquier.getJeu()[4][4].setPiece(pion);
        echiquier.getJeu()[1][4].setPiece(new Pion("P","noir"));
        echiquier.getJeu()[9][4].setPiece(roiRouge);
        assertEquals(true, echiquier.roisNePouvantPasEtreFaceAFace(new Position(4,4), new Position(4,5)));
    }

    @Test
    public void testInvalide2PiecesEntreRoiPionDansPalaisRouge(){
        echiquier.getJeu()[0][4].setPiece(roiNoir);
        echiquier.getJeu()[4][4].setPiece(pion);
        echiquier.getJeu()[8][4].setPiece(new Pion("P","rouge"));
        echiquier.getJeu()[7][4].setPiece(roiRouge);
        assertEquals(false, echiquier.roisNePouvantPasEtreFaceAFace(new Position(4,4), new Position(4,5)));
    }

    @Test
    public void testInvalide2PiecesEntreRoiPionDansPalaisNoir(){
        echiquier.getJeu()[2][4].setPiece(roiNoir);
        echiquier.getJeu()[1][4].setPiece(new Pion("X","noir"));
        echiquier.getJeu()[4][4].setPiece(pion);
        echiquier.getJeu()[9][4].setPiece(roiRouge);
        assertEquals(false, echiquier.roisNePouvantPasEtreFaceAFace(new Position(4,4), new Position(4,5)));
    }


    @Test
    public void testValidePieceMobilePasSurColonne(){
        echiquier.getJeu()[0][4].setPiece(roiNoir);
        echiquier.getJeu()[4][7].setPiece(pion);
        echiquier.getJeu()[5][4].setPiece(new Pion("X","rouge"));
        echiquier.getJeu()[9][4].setPiece(roiRouge);
        assertEquals(true, echiquier.roisNePouvantPasEtreFaceAFace(new Position(4,7), new Position(4,6)));
    }

    @Test
    public void testValideRoiSurColonneDifferente(){
        echiquier.getJeu()[0][4].setPiece(roiNoir);
        echiquier.getJeu()[4][4].setPiece(pion);
        echiquier.getJeu()[9][5].setPiece(roiRouge);
        assertEquals(true, echiquier.roisNePouvantPasEtreFaceAFace(new Position(4,4), new Position(4,5)));
    }

    @Test
    public void testInvalideLePionBloqueLaVueDesRois()
    {
        echiquier.getJeu()[0][4].setPiece(roiNoir);
        echiquier.getJeu()[4][4].setPiece(pion);
        echiquier.getJeu()[9][4].setPiece(roiRouge);
        assertEquals(false, echiquier.roisNePouvantPasEtreFaceAFace(new Position(4,4), new Position(4,5)));
    }

    @Test
    public void testValideRoiSeDeplaceSurUneAutreColonne(){

        echiquier.getJeu()[0][4].setPiece(new Roi("!","noir"));
        echiquier.getJeu()[4][4].setPiece(new Pion("X","rouge"));
        echiquier.getJeu()[9][4].setPiece(roiRouge);
        assertEquals(true, echiquier.roisNePouvantPasEtreFaceAFace(new Position(0,4), new Position(0,5)));
    }

    @Test
    public void testValideRoiSeDeplaceSurLaColonneAvecUnPionQuiBloque(){

        echiquier.getJeu()[0][5].setPiece(new Roi("!","noir"));
        echiquier.getJeu()[4][4].setPiece(new Pion("X","rouge"));
        echiquier.getJeu()[9][4].setPiece(roiRouge);
        assertEquals(true, echiquier.roisNePouvantPasEtreFaceAFace(new Position(0,5), new Position(0,4)));
    }

    @Test
    public void testInvalideLaColonneEstVideDevantLautreRoi()
    {
        echiquier.getJeu()[0][5].setPiece(new Roi("!","noir"));
        echiquier.getJeu()[4][8].setPiece(new Pion("X","rouge"));
        echiquier.getJeu()[9][4].setPiece(roiRouge);
        assertEquals(false, echiquier.roisNePouvantPasEtreFaceAFace(new Position(0,5), new Position(0,4)));
    }

    @Test
    public void testValideDiagonaleDerrierePion(){
        echiquier.getJeu()[1][5].setPiece(roiNoir);
        echiquier.getJeu()[1][4].setPiece(new Pion("P","noir"));
        echiquier.getJeu()[8][5].setPiece(new Pion("X","rouge"));
        echiquier.getJeu()[8][4].setPiece(new Roi("!","rouge"));
        assertEquals(true, echiquier.roisNePouvantPasEtreFaceAFace(new Position(8,4), new Position(9,5)));
    }

    @Test
    public void testInvalideDiagonaleDevantPion(){
        echiquier.getJeu()[1][5].setPiece(roiNoir);
        echiquier.getJeu()[1][4].setPiece(new Pion("P","noir"));
        echiquier.getJeu()[8][5].setPiece(new Pion("X","rouge"));
        echiquier.getJeu()[8][4].setPiece(new Roi("!","rouge"));
        assertEquals(false, echiquier.roisNePouvantPasEtreFaceAFace(new Position(8,4), new Position(7,5)));
    }
}















