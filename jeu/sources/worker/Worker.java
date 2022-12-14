package sources.worker;

import java.util.ArrayList;

public class Worker
{
    private static int id0 = 0;
    private static int id1 = 0;
    private static char id2 = 'A';
    private ArrayList<Partie> parties;

    public Worker()
    {
        this.parties = new ArrayList<Partie>();
    }

    public void addJoueurTo(String idPartie, String pseudo)
    {
        for (Partie p : this.parties)
            if (p.getID().equals(idPartie)) p.addJoueur(new Joueur(pseudo, false));
    }

    public boolean addBotTo(String idPartie)
    {
        for (Partie p : this.parties)
            if (p.getID().equals(idPartie))
                if (p.getNbJoueurs() != 4)
                {
                    p.addJoueur(new Joueur("BOT" + p.getCharBot(), true));
                    return true;
                }

        return false;
    }

    public void exclure(String id, String pseudo)
    {
        for (Partie p : this.parties)
            if (p.getID().equals(id))
                p.exclure(pseudo);
    }

    public String getPseudos(String id)
    {
        for (Partie p : this.parties)
            if (p.getID().equals(id))
                return p.getPseudos();
        return "moi";
    }

    // Crée un ID et une partie en même temps
    public String getNewID()
    {
        if (id2 == 'Z') id2 = 'A';
        String sRet = "";
        switch ((int)(Math.random() * 3))
        {
            case 0 : sRet =(id0++) +""+ id1 +""+ id2; break;
            case 1 : sRet =id0 +""+ (id1++) +""+ id2; break;
            case 2 : sRet =id0 +""+ id1 +""+ (id2++);
        }
        this.parties.add(new Partie(sRet, new Joueur("moi", false)));
        return sRet;
    }

    public int getNbJoueurs(String idPartie)
    {
        for (Partie p : this.parties)
            if (p.getID().equals(idPartie)) return p.getNbJoueurs();
        return 4;
    }

    public String[] getCartes(String id, String pseudo)
    {
        for (Partie p : this.parties)
            if (p.getID().equals(id)) return p.getCartes(pseudo);
        return new String[0];
    }

    public char getCoulLastCarte(String id)
    {
        for (Partie p : this.parties)
            if (p.getID().equals(id)) return p.getCoulLastCarte();
        return 'N';
    }

    public String getValLastCarte(String id)
    {
        for (Partie p : this.parties)
            if (p.getID().equals(id)) return p.getValLastCarte();
        return "CC";
    }

    public void lancerPartie(String id)
    {
        for (Partie p : this.parties)
            if (p.getID().equals(id)) p.demarrer();
    }

    public void setPret(String id, String pseudo)
    {
        for (Partie p : this.parties)
            if (p.getID().equals(id)) p.setPret(pseudo);
    }

    public void jouer(String id, String val, char coul)
    {
        for (Partie p : this.parties)
            if (p.getID().equals(id)) p.jouer(val,coul);
    }

    public String getLastCarte(String id)
    {
        for (Partie p : this.parties)
            if (p.getID().equals(id)) return p.getValLastCarte() + " " + p.getCoulLastCarte();
        return null;
    }

// Paramètres de partie
    public void reinitialiserParam(String id)
    {
        for (Partie p : this.parties)
            if (p.getID().equals(id)) p.reinitialiserParam();
    }

    public void PM(String id, boolean b)
    {
        for (Partie p : this.parties)
            if (p.getID().equals(id)) p.PM(b);
    }

    public void ST(String id, boolean b)
    {
        for (Partie p : this.parties)
            if (p.getID().equals(id)) p.ST(b);
    }

    public void PR(String id, boolean b)
    {
        for (Partie p : this.parties)
            if (p.getID().equals(id)) p.PR(b);
    }

    public void EQ(String id, boolean b)
    {
        for (Partie p : this.parties)
            if (p.getID().equals(id)) p.EQ(b);
    }

    public void nbCartesParJoueur(String id, int n)
    {
        for (Partie p : this.parties)
            if (p.getID().equals(id)) p.nbCartesParJoueur(n);
    }
}