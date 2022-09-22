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
            case 0 : sRet =(id0++) + id1 +""+ id2; break;
            case 1 : sRet =id0 + (id1++) +""+ id2; break;
            case 2 : sRet =id0 + id1 +""+ (id2++);
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
}