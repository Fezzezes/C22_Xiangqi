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

//        debuter();
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

    public  Intersection getIntersection(Position p){
        //Permet de simplifié certain appel de la méthode getIntersection
        return  getIntersection(p.getLigne(), p.getColonne());
    }

    @Override
    public boolean cheminPossible(Position depart , Position arrivee){

        System.out.println("["+depart.getLigne()+", "+depart.getColonne()+"] -> ["+arrivee.getLigne()+", "+arrivee.getColonne()+"]");

        if(depart.equals(arrivee))
        {
            System.out.println("Déplacement NULL est valide");
            return true;
        }

        //traque le pièce trouvé entre le départ et l'arrivée
        int pieceDansLeChemin = 0;

        //si la pièce bouge de |gauche à droite| ou de |droite à gauche| ou |ne bouge pas verticalement|
        int incrementeLigne = trouveDirectionDeLaPiece(depart.getLigne(), arrivee.getLigne());
        //si la pièce bouge de |haut en bas| ou de |bas en haut| ou |ne bouge pas horizontalement|
        int incrementeColonne = trouveDirectionDeLaPiece(depart.getColonne(), arrivee.getColonne());

        //le cavalier à une vérification spéciale
        if(getIntersection(depart).getPiece() instanceof Cavalier){
            //Pour le cavalier, seulement évaluer le premier déplace (horizontal ou vertical), et la méthode estOccupeParAmi(depart, arrivee) à
            //la fin s'occupera de la position d'arrivée en diagonale

            //incrementé seulement l'horizontale OU le verticale, pas les deux
            if(cavalierBougeVers(depart, arrivee).equals("ligne"))
                incrementeColonne = 0;
            else
                incrementeLigne = 0;
            //regarde la prochaine position
            if(estOccupe(depart.getLigne() + incrementeLigne, depart.getColonne()+incrementeColonne))
                pieceDansLeChemin++;
        }
        else {
            //prochaine position dans la chaine a vérifié
            Position prochainePosition = new Position(depart.getLigne() + incrementeLigne, depart.getColonne() + incrementeColonne);
            //examine de façon recursive chaque intersection ENTRE le point de départ et le point d'arrivée, retourne le compte
            pieceDansLeChemin += pieceSurPosition(prochainePosition, arrivee, incrementeLigne, incrementeColonne, pieceDansLeChemin);
        }

        System.out.println("Il y a { "+pieceDansLeChemin+" } pièces ENTRE le départ et l'arrivée");
        System.out.println("*** Vérification de l'arrivée ***");

        //Si il y a exactement une pièce entre la bombarde et son arrivée, vérifié que l'arrivé EST un ennemi
        if(getIntersection(depart).getPiece() instanceof Bombarde)
            return deplacementBombarde(depart, arrivee, pieceDansLeChemin);

        //Une pièce n'ayant pas de piece dans son chemin ET ayant un arrivée vide ou ennemi retourne vrai
        return pieceDansLeChemin < 1 && !estOccupeParAmi(depart, arrivee);
    }

    private int trouveDirectionDeLaPiece(int depart, int arrivee){

        //si la valeur de départ est plus grand, l'incrementation sera négative (la piece se dirigera vers la gauche ou vers le haut)
        if(depart > arrivee)
            return -1;
        //si la valeur de départ est plus petite, l'incrementation sera positive (la piece se dirigera vers la droite ou vers le bas)
        else if (depart < arrivee)
            return 1;
        //si la valeur de départ est égale, aucune incrementation, (la pièce bougera seulement sur l'horizontale ou la verticale)
        else
            return 0;
    }


    private boolean deplacementBombarde(Position depart , Position arrivee, int pieceDansLeChemin){

        //Une bombarde DOIT avoir une piece dans son chemin pour capturer
        if(pieceDansLeChemin == 1)
        {
            boolean estEnnemi = estOccupeParEnnemi(depart, arrivee);
            System.out.println("La bombarde saute une pièce et capture ----> "+estEnnemi );
            return estEnnemi;
        }
        else
        {
            boolean estVide = !estOccupe(arrivee);
            System.out.println("La bombarde à le chemin libre ----> "+(pieceDansLeChemin < 1 && estVide));
            //Sinon elle peut seulement ce déplacé sur une intersection vide avec un chemin non-obstrué
            return pieceDansLeChemin < 1 && estVide;
        }
    }


    private String cavalierBougeVers(Position depart , Position arrivee){

        int ligne = Math.abs(depart.getLigne() - arrivee.getLigne());
        int colonne = Math.abs(depart.getColonne() - arrivee.getColonne());
        //si la différence entre les lignes et plus élevé que la différence entre les colonnes, le cavalier initialement bouger de facon verticale
        //sinon le cavalier bougera horizontalement en premier
        return ligne > colonne? "ligne": "colonne";
    }

    private int pieceSurPosition(Position actuelle, Position arrivee, int incrLigne, int incrColonne, int compte ){

        //nous sommes arrivées à la dernière position de la chaine recursive
        //retourne le compte de pieces trouvées entre la position de départ et la position d'arrivée
        if(actuelle.equals(arrivee))
            return compte;

        //la position actuelle est-elle occupé, si oui ajoute au compte
        if(estOccupe(actuelle))
            compte++;

        //prochaine position a vérifié
        Position prochainePosition = new Position(actuelle.getLigne()+incrLigne, actuelle.getColonne()+incrColonne);

        //continu recursivement avec la prochaine position
        return pieceSurPosition(prochainePosition, arrivee,incrLigne, incrColonne, compte);
    }

    @Override
    public boolean roisNePouvantPasEtreFaceAFace ( Position depart,Position arrivee ){

        //Un mouvement vertical va toujours bloqué la vue des rois
        if(depart.getColonne() == arrivee.getColonne())
            return true;

        //il nous faut la position des rois pour faire nos vérifications et savoir si la piece en jeu est elle-même un roi
        Position roiNoir = positionDuRoi("noir");
        Position roiRouge = positionDuRoi("rouge");
        boolean pieceEstRoi = (getIntersection(depart).getPiece() instanceof Roi);

        if(!pieceEstRoi) {
            //si la piece en jeu n'est pas sur la colonne des rois, son déplacement n'aura aucun impact
            //de plus, si les rois ne sont pas sur la même colonne, se teste retournera vrai aussi
            if(depart.getColonne() != roiNoir.getColonne() || depart.getColonne() != roiRouge.getColonne()) {
                System.out.println("Les pieces concernées ne sont pas alignées");
                return true;
            }
        }

        //un roi ne peut pas se placer dans ma même colonne que le roi adverse si la colonne est vide
        //Si la piece en jeu est un roi, on va donner la position d'arrivé au roi concerné pour permettre
        //à la methode pieceEntreRois() de fonctionné en considérant la position futur du roi au lieu de sa position actuelle
        if(roiNoir.equals(depart))
            roiNoir = arrivee;
        else if(roiRouge.equals(depart))
            roiRouge = arrivee;

        return pieceEntreRois(roiNoir, roiRouge, pieceEstRoi);
    }

    private Position positionDuRoi(String couleur) {

        int lignePalais = 0;
        //change la ligne de depart du palais pour scanner le palais rouge
        if(couleur.equals("rouge")) {
            lignePalais = 7;
        }

        //loop au travers du palais et retourne le roi
        for(int ligne = lignePalais; ligne<lignePalais+3;ligne++) {
            for(int colonne = 3; colonne < 6; colonne++){

                Position position = new Position(ligne, colonne);
                //la position est occupé par un roi
                if(getIntersection(position).getPiece() instanceof Roi) {
                    System.out.println("Roi a été trouvé sur ["+position.getLigne()+", "+position.getColonne()+"]");
                    return position;
                }
            }
        }

        System.out.println("PAS DE ROI DANS LE PALAIS?????");
        return null;
    }


    private boolean pieceEntreRois(Position roi1, Position roi2, boolean estUnRoi) {
        //les rois ne sont pas sur la même colonne, le teste sera toujours positif
        //retourne vrai
        System.out.println("-----");
        if (roi1.getColonne() != roi2.getColonne()) {

            System.out.println("Les rois ne seront plus sur la même colonne");
            return true;
        }

        int compte = 0;
        for (int ligne = roi1.getLigne()+1; ligne < roi2.getLigne(); ligne++) {

            if(estOccupe(ligne, roi1.getColonne()))
                compte++;
        }

        //si il y a seulement une pièce entre les rois, la piece sur la colonne ne peut pas bouger
        //si il y a aucune pièce sur la colonne du roi1, le roi2 ne pourra pas si déplacé
        //retourne faux
        System.out.println("La pièce qui se déplace est un roi -> "+estUnRoi);
        System.out.println("Il y a "+compte+" piece entre les rois");
        return (compte > 1 && !estUnRoi) || (compte > 0 && estUnRoi);
    }

    //----------------------------------------------------Util---------------------------------------
    public void afficher() {

        System.out.printf("    ");
        for(int colonne = 0; colonne < NOMBRE_COLONNES; colonne++ ) {
            System.out.printf(String.valueOf(colonne) + "    ");
        }
        System.out.println("\n =============================================");

        for(int ligne = 0; ligne < NOMBRE_LIGNES; ligne++) {
            //pour chaque colonne
            System.out.printf(String.valueOf(ligne)+ "|  ");
            for(int colonne = 0; colonne < NOMBRE_COLONNES; colonne++ ) {

                System.out.printf(String.valueOf(jeu[ligne][colonne].getPieceName()) + "   ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    private boolean estOccupe(int ligne, int colonne){
        //vérifie si la position est occupé
        boolean occupe = getIntersection(ligne, colonne).getPiece() != null;
        System.out.println("Looking at: "+ligne+", "+colonne+" : occupé -> "+occupe );

        return occupe;
    }

    private boolean estOccupe(Position positon){
        //Je suis tanné de la ligne et la colonne séparé
        return estOccupe(positon.getLigne(), positon.getColonne());
    }

    private boolean estOccupeParAmi(Position depart, Position arrivee){

        //retourne faux si l'intersection est occupé, sinon vérifie la couleur
        if(estOccupe(arrivee)) {

            String couleurAmi = getIntersection(depart).getPiece().getCouleur();
            String couleurPieceArrivee = getIntersection(arrivee).getPiece().getCouleur();
            boolean memeCouleur = (couleurAmi.equals(couleurPieceArrivee));

            System.out.println("Pièce détectée est amie ("+couleurAmi+") -> "+memeCouleur);
            //l'intersection est occupé, retourne true si la piece sur celle-ci EST la même couleur que la piece en jeu
            return memeCouleur;
        }
        else
            return false;
    }

    private boolean estOccupeParEnnemi(Position depart, Position arrivee){

        //retourne faux si l'intersection est occupé, sinon vérifie la couleur
        if(estOccupe(arrivee))
        {
            String couleurAmi = getIntersection(depart).getPiece().getCouleur();
            String couleurPieceArrivee = getIntersection(arrivee).getPiece().getCouleur();
            boolean couleurDifferente = !(couleurAmi.equals(couleurPieceArrivee));

            System.out.println("Pièce détectée est ennmie ("+couleurAmi+") -> "+couleurDifferente);
            //l'intersection est occupé, retourne true si la piece sur celle-ci N'EST PAS la même couleur que la piece en jeu
            return couleurDifferente;
        }
        else
            return false;
    }
}
