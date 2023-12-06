package xiangqi.echiquier;

import xiangqi.piece.*;

public class Echiquier implements MethodesEchiquier{

    private Intersection[][] jeu;
    private final int NOMBRE_LIGNES = 10;
    private final int NOMBRE_COLONNES = 9;


    public Intersection[][] getJeu() {
        return jeu;
    }

    public Echiquier(){

        jeu = new Intersection[NOMBRE_LIGNES][NOMBRE_COLONNES];
        //pour chaque ligne
        for(int ligne = 0; ligne < NOMBRE_LIGNES; ligne++)
        {
            //pour chaque colonne
            for(int colonne = 0; colonne <NOMBRE_COLONNES;colonne++ )
            {
                jeu[ligne][colonne] = new Intersection();
            }
        }

        debuter();
//        afficher();

    }
    @Override
    public void debuter(){

        //T:[0¸0][0¸8] / [9¸0][9¸8]
        //C:[0¸1][0¸7] / [9¸1][9¸7]
        //E:[0¸2][0¸6] / [9¸2][9¸6]
        //M:[0¸3][0¸5] / [9¸3][9¸5]
        //R:[0¸4] / [9¸4]
        //B:[2¸1][2¸7] / [7¸1][7¸7]
        //P:[3¸0][3¸2][3¸4][3¸6][3¸8] / [6¸0][6¸2][6¸4][6¸6][6¸8]

        jeu[0][0].setPiece(new Char("T","noir"));
        jeu[0][8].setPiece(new Char("T","noir"));
        jeu[9][0].setPiece(new Char("T","rouge"));
        jeu[9][8].setPiece(new Char("T","rouge"));

        jeu[0][1].setPiece(new Cavalier("C","noir"));
        jeu[0][7].setPiece(new Cavalier("C","noir"));
        jeu[9][1].setPiece(new Cavalier("C","rouge"));
        jeu[9][7].setPiece(new Cavalier("C","rouge"));

        jeu[0][2].setPiece(new Elephant("E","noir"));
        jeu[0][6].setPiece(new Elephant("E","noir"));
        jeu[9][6].setPiece(new Elephant("E","rouge"));
        jeu[9][2].setPiece(new Elephant("E","rouge"));


        jeu[0][3].setPiece(new Mandarin("M","noir"));
        jeu[0][5].setPiece(new Mandarin("M","noir"));
        jeu[9][3].setPiece(new Mandarin("M","rouge"));
        jeu[9][5].setPiece(new Mandarin("M","rouge"));


        jeu[0][4].setPiece(new Roi("R","noir"));
        jeu[9][4].setPiece(new Roi("R","rouge"));

        jeu[2][1].setPiece(new Bombarde("B","noir"));
        jeu[2][7].setPiece(new Bombarde("B","noir"));
        jeu[7][1].setPiece(new Bombarde("B","rouge"));
        jeu[7][7].setPiece(new Bombarde("B","rouge"));


        for(int colonne = 0; colonne<NOMBRE_COLONNES; colonne+=2)
        {
            jeu[3][colonne].setPiece(new Pion("P","noir"));
            jeu[6][colonne].setPiece(new Pion("P","noir"));
        }

    }

    @Override
    public  Intersection getIntersection( int ligne, int colonne ){
        return jeu[ligne][colonne];
    }

    @Override
    public  boolean cheminPossible (Position depart , Position arrivee){
        int pieceDansLeChemin = 0;




        pieceDansLeChemin += pieceSurLaligne(depart , arrivee);


        System.out.println("#---#");
        //invalide si la derniere position est occupé par un ami
        if(estOccupeParAmi(depart, arrivee))
            pieceDansLeChemin=1000;

        System.out.println("");

        return pieceDansLeChemin <= 0;
    }



    public int pieceSurLaligne(Position depart, Position arrivee){

        System.out.println("["+depart.getLigne()+", "+depart.getColonne()+"] -> ["+arrivee.getLigne()+", "+arrivee.getColonne()+"]");

        //détermine le nombre de piece ]ENTRE[ le depart et l'arrivée
        int pieceSurLigne = 0;

        //Le loop doit toujours aller de gauche à droite
        int indexDepart = depart.getColonne()+1;
        int indexFin = arrivee.getColonne();
        
        if(depart.getColonne() > arrivee.getColonne())
        {
            indexDepart = arrivee.getColonne()+1;
            indexFin = depart.getColonne();
        }

        //loop de gauche à droite sur la ligne à partir de l'index de départ
        for(int colonne = indexDepart; colonne < indexFin ; colonne++) {

            if(estOccupe(depart.getLigne(), colonne))
                pieceSurLigne++;

        }

        System.out.println("Il y a "+pieceSurLigne+" pièces entre le départ et l'arrivée (horizontal)");
        return pieceSurLigne;
    }

    public int pieceSurLaColonne(Position depart, Position arrivee){

        System.out.println("["+depart.getLigne()+", "+depart.getColonne()+"] -> ["+arrivee.getLigne()+", "+arrivee.getColonne()+"]");
        int pieceSurLaColonne= 0;

        //Le loop doit toujours aller de gauche à droite
        int indexDepart = depart.getLigne()+1;
        int indexFin = arrivee.getLigne();
        if(depart.getLigne() > arrivee.getLigne())
        {
            indexDepart = arrivee.getLigne()+1;
            indexFin = depart.getLigne();
        }

        for(int ligne = indexDepart; ligne< indexFin; ligne++) {

            if(estOccupe(ligne, depart.getColonne()))
                pieceSurLaColonne++;
        }

        System.out.println("Il y a "+pieceSurLaColonne+" pièces entre le départ et l'arrivée (vertical)");
        return pieceSurLaColonne;
    }


    public boolean colonneEstLibre(Position depart , Position arrivee){
        return false;
    }

    public boolean diagonaleEstLibre(Position depart , Position arrivee){
        return false;
    }



    @Override
    public  boolean roisNePouvantPasEtreFaceAFace ( Position depart,Position arrivee ){
        System.out.println("OVERRIDE THIS");return false;
    }


    //----------------------------------------------------Util---------------------------------------
    public void afficher()
    {

        for(int ligne = 0; ligne < NOMBRE_LIGNES; ligne++)
        {
            //pour chaque colonne
            for(int colonne = 0; colonne < NOMBRE_COLONNES; colonne++ )
            {
                System.out.printf(String.valueOf(jeu[ligne][colonne].getPieceName()) + "   ");
            }

            System.out.println("");
        }
        System.out.println("");
    }

    private boolean pieceAvance(Position depart , Position arrivee){
        //détermine si une piece avance(true) ou recule(false) du point de vue des noirs
        System.out.println("La piece bouge vers la gauche: "+(depart.getColonne() < arrivee.getColonne()));
        System.out.println("La piece bouge vers le bas: "+(depart.getLigne() < arrivee.getLigne()));
        return (depart.getLigne() < arrivee.getLigne() || depart.getColonne() < arrivee.getColonne());
    }

    public boolean estOccupe(int ligne, int colonne){
        //vérifie si la position est occupé
        System.out.println("Looking at: "+ligne+", "+colonne+" : occupé -> "+(getIntersection(ligne, colonne).getPiece() != null));
        return getIntersection(ligne, colonne).getPiece() != null;
    }

    public boolean estOccupeParAmi(Position depart, Position arrivee){

        //retourne faux si l'intersection est occupé, sinon vérifie la couleur
        if(estOccupe(arrivee.getLigne(), arrivee.getColonne()))
        {
            String couleurAmi = getIntersection(depart.getLigne(), depart.getColonne()).getPiece().getCouleur();
            System.out.println("Cette pièce est-elle "+couleurAmi+"? -> "+(getIntersection(arrivee.getLigne(), arrivee.getColonne()).getPiece().getCouleur().equals(couleurAmi)));
            //l'intersection est occupé, retourne true si la piece sur celle-ci N'A PAS la même couleur que la piece en jeu
            return getIntersection(arrivee.getLigne(), arrivee.getColonne()).getPiece().getCouleur().equals(couleurAmi);
        }
        else
            return false;
    }
}
