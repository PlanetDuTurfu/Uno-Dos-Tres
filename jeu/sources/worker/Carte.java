package sources.worker;

public class Carte
{
    private String valeur;
    private char couleur;
    private boolean peutEtreJoue;
    private boolean active;

    public Carte(String valeur, char couleur)
    {
        this.valeur = valeur;
        this.couleur = couleur;
        this.peutEtreJoue = false;
        this.active = true;
    }

    public String getValeur()
    {
        return this.valeur;
    }

    public char getCouleur()
    {
        return this.couleur;
    }

    public void peutEtreJoue()
    {
        this.peutEtreJoue = true;
    }

    public void nePeutPasEtreJoue()
    {
        this.peutEtreJoue = false;
    }

    public boolean peutElleEtreJoue()
    {
        return this.peutEtreJoue;
    }

    public boolean estActive()
    {
        return this.active;
    }

    public void plusActive()
    {
        this.active = false;
    }

    public String toString()
    {
        return "[" + this.valeur + " " + this.couleur + "]";
    }
}