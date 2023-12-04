package xiangqi;

/**
 * classe abstraite Piece servant de point de départ pour tous les types de pièces d'un jeu de Xiangqi
 * @author Éric Labonté
 * @version 3
 */

public abstract class Piece {

    /**
     * nom de la pièce selon les conventions
     */
    private String nom;
    /**
     * couleur de la pièce
     */
    private String couleur;


// constructeur permettant d'initialiser le nom et la couleur d'un objet Piece

    public Piece (String nom, String couleur)
    {
        setNom(nom);
        setCouleur ( couleur );
    }

    public String getNom ()
    {
        return nom;
    }

    public void setNom (String nom)
    {
        this.nom = nom;
    }

    public String getCouleur ()
    {
        return couleur;
    }

    public void setCouleur ( String couleur )
    {
        if (( couleur == "noir" ) || ( couleur == "rouge" ))
            this.couleur = couleur;
    }

    /**
     *méthode permettant de calculer la norme mathématique entre deux Positions
     * @param depart Position de départ
     * @param arrivee Position d'arrivée de la Pièce
     * @return la somme des carrés des distances
     *
     */
    public double norme (Position depart, Position arrivee)
    {
        //un déplacement de '1' à l'horizontal ou à la verticale donnera TOUJOURS '1'
        //un déplacement de '1' à la diagonale donnera TOUJOURS '2'
        return Math.pow((depart.getLigne()-arrivee.getLigne()), 2)+ Math.pow((depart.getColonne() - arrivee.getColonne()),2);
    }

    public boolean estDansPalais(Position arrivee){
        //Retourne Faux si le déplacement n'est pas dans le palais

        System.out.println("Couleur: "+this.getCouleur());
        System.out.println(arrivee.getColonne() +" < 3? : "+(arrivee.getColonne() < 3));
        System.out.println(arrivee.getColonne() +" > 5? : "+(arrivee.getColonne() > 5));
        System.out.println(arrivee.getLigne() +" < "+(arrivee.getLigne() < 7)+"? : "+(arrivee.getLigne() < 7));
        System.out.println(arrivee.getLigne() +" > "+(arrivee.getLigne() > 9)+"? : "+(arrivee.getLigne() > 9));

        if((arrivee.getColonne() < 3 || arrivee.getColonne() > 5) )
            return false;

        if(this.getCouleur().equals("noir") && arrivee.getLigne() > 2)
            return false;

        else if(this.getCouleur().equals("rouge") && arrivee.getLigne() < 7)
            return false;
        else
            return true;
    }

    public boolean traverseLaRiviere(Position arrivee){

        //La rivière ne peut être traversé, dependant de la couleur
        if(this.getCouleur().equals("noir") && arrivee.getLigne() > 4)
            return true;
        else if (this.getCouleur().equals("rouge") && arrivee.getLigne() < 5)
            return true;
        else
            return false;
    }

    /* méthode abstraite à implémenter dans chacune des sous - classes */

    public abstract boolean estValide (Position depart, Position arrivee);


}
