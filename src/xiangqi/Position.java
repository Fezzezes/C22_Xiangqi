package xiangqi;

public class Position
{

    private int ligne ; // de 0 à 9 voir schéma
    private int colonne; // de 0 à 8

    //Le palais se trouve à la position NOIR
    // [3,0],[4,0],[5,0]
    // [3,1],[4,1],[5,1]
    // [3,2],[4,2],[5,2]

    //Le palais se trouve à la position ROUGE
    // [3,7],[4,7],[5,7]
    // [3,8],[4,8],[5,8]
    // [3,9],[4,9],[5,9]

    //Le coté NOIR se trouve dans les lignes de '0' à '4'
    //Le coté ROUGE se trouve dans les lignes de '5' à '9'


    public Position(int ligne, int colonne)
    {
        this.ligne = ligne;
        this.colonne= colonne;
    }

    public int getLigne ()
    {
        return ligne;
    }

    public int getColonne ()
    {
        return colonne;
    }

    public void setLigne (int ligne)
    {
        this.ligne = ligne;
    }

    public void setColonne ( int colonne )
    {
        this.colonne = colonne;
    }

}
