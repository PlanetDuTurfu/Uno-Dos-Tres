package sources;

import sources.worker.Worker;
import sources.gui.Frame;

public class Controleur
{
    private Worker work;
    private Frame gui;

    public Controleur()
    {
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

    public boolean addBot(String idPartie)
    {
        return this.work.addBotTo(idPartie);
    }

    public void exclure(String id, String pseudo)
    {
        this.work.exclure(id,pseudo);
    }
}