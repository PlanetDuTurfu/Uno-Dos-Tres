package sources.worker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class Joueur
{
    private String pseudo;
    private ArrayList<Carte> main;

    public Joueur(String pseudo)
    {
        this.pseudo = pseudo;
        this.main = new ArrayList<Carte>();
    }

    public String getPseudo()
    {
        return this.pseudo;
    }

    public boolean peutJouer(Carte c)
    {
        String valeur = c.getValeur();
        char couleur = c.getCouleur();
        for (Carte carte : this.main)
        {
            if (couleur == carte.getCouleur() || valeur.equals(carte.getValeur())) carte.peutEtreJoue();
            else carte.nePeutPasEtreJoue();
        }

        for (Carte carte : this.main)
            if (carte.peutElleEtreJoue()) return true;
        return false;
    }

    public void trierCartes()
    {
        Collections.sort(this.main, new Tri());
    }

    public void addCarte(Carte c)
    {
        this.main.add(c);
    }

    public void retirerCarte(Carte c)
    {
        this.main.remove(c);
    }

    public String toString()
    {
        String sRet = this.pseudo + " : ";
        for (Carte c : main)
            sRet += c + " ";
        return sRet;
    }
}

class Tri implements Comparator<Carte>
{
    public int compare(Carte a, Carte b)
    {
        if ((int)a.getCouleur() == (int)'N') return 1;
        if ((int)b.getCouleur() == (int)'N') return -1;
        if ((int)a.getCouleur() - (int)b.getCouleur() > 0) return -1;
        if ((int)a.getCouleur() - (int)b.getCouleur() < 0) return 1;
        
        //à ce point du programme la couleur est la même
        //donc on va les trier selon la valeur
        String v1 = a.getValeur();
        String v2 = b.getValeur();
        boolean bA = false;
        try
        {
            int chiffre1 = Integer.parseInt(v1);
            bA = true;
            int chiffre2 = Integer.parseInt(v2);
            // Arrivé ici on sait que ce sont tous les deux des chiffres
            return chiffre1 - chiffre2;
        } catch(Exception e){}

        /* Si a est un chiffre mais b ne l'est pas */
        if (bA) return -1;

        /* Sinon */
        boolean bB = false;

        try
        {
            Integer.parseInt(v2);
            // Si b est un chiffre
            return 1;
        } catch(Exception e){}

        /* a et b ne sont pas des chiffres */
        
        if (v1.equals("cs"))
        {
            if (v2.equals("cs")) return 0;
            if (v2.equals("si") || v2.equals("p2") || v2.equals("st")) return -1;
        }
        if (v1.equals("si"))
        {
            if (v2.equals("cs")) return 1;
            if (v2.equals("si")) return 0;
            if (v2.equals("p2") || v2.equals("st")) return -1;
        }
        if (v1.equals("p2"))
        {
            if (v2.equals("cs") || v2.equals("si")) return 1;
            if (v2.equals("p2")) return 0;
            if (v2.equals("st")) return -1;
        }
        if (v1.equals("st"))
        {
            if (v2.equals("cs") || v2.equals("si") || v2.equals("p2")) return 1;
            if (v2.equals("st")) return 0;
        }

        if (v1.equals("p4")) return 1;
        if (v2.equals("p4")) return -1;
        return 0;
    }
}