package sources;

import sources.worker.Worker;
import sources.gui.Frame;

public class Controleur
{
    private Worker work;
    private Frame gui;
    private String pseudo;

    public Controleur(String pseudo)
    {
        this.pseudo = pseudo;
        this.work = new Worker();
        this.gui = new Frame(this);
    }

    public void accueil()
    {
        this.gui.accueil();
    }

    public void lobby()
    {
        this.gui.lobby();
    }

    public void leave()
    {
        this.gui.dispose();
    }

    public void setRatio(float ratio)
    {
        this.gui.setRatio(ratio);
    }

    public void echap()
    {
        this.gui.echap();
    }

    public void resize()
    {
        this.gui.resize();
    }

    public String getID()
    {
        return this.gui.getID();
    }

    public String getNewID()
    {
        return this.work.getNewID();
    }

    public int getNbJoueurs(String idPartie)
    {
        return this.work.getNbJoueurs(idPartie);
    }

    public String getPseudos(String id)
    {
        return this.work.getPseudos(id);
    }

    public String getPseudo()
    {
        return this.pseudo;
    }

    public boolean addBot(String idPartie)
    {
        return this.work.addBotTo(idPartie);
    }

    public void exclure(String id, String pseudo)
    {
        this.work.exclure(id,pseudo);
    }

    public void lancerPartie(String id)
    {
        this.work.lancerPartie(id);
        this.gui.partie();
    }

    public void setPret(String id, String pseudo)
    {
        this.work.setPret(id,pseudo);
    }

    public void reinitialiserParam(String id)
    {
        this.gui.reinitialiserParam();
        this.work.reinitialiserParam(id);
    }

    public void PM(String id, boolean b)
    {
        this.work.PM(id,b);
    }

    public void ST(String id, boolean b)
    {
        this.work.ST(id,b);
    }

    public void PR(String id, boolean b)
    {
        this.work.PR(id,b);
    }

    public void EQ(String id, boolean b)
    {
        this.work.EQ(id,b);
    }
}