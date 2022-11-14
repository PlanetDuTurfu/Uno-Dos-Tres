package sources;

import sources.worker.Worker;
import sources.gui.Frame;

public class Controleur
{
    private Worker work;
    private Frame gui;
    private String pseudo;
    private String id;

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
        return this.id;
    }

    public void getNewID()
    {
        this.id = this.work.getNewID();
    }

    public String getPseudo()
    {
        return this.pseudo;
    }

    public int getNbJoueurs()
    {
        return this.work.getNbJoueurs(this.id);
    }

    public int getNbCartes(String pseudo)
    {
        return this.work.getCartes(this.id,pseudo).length;
    }

    public String[] getCartes(String pseudo)
    {
        return this.work.getCartes(this.id,pseudo);
    }

    public String getValLastCarte()
    {
        return this.work.getValLastCarte(this.id);
    }
    
    public char getCoulLastCarte()
    {
        return this.work.getCoulLastCarte(this.id);
    }

    public String getPseudos()
    {
        return this.work.getPseudos(this.id);
    }

    public boolean addBot()
    {
        return this.work.addBotTo(this.id);
    }

    public void reinitialiserParam()
    {
        this.gui.reinitialiserParam();
        this.work.reinitialiserParam(this.id);
    }

    public void lancerPartie()
    {
        this.work.lancerPartie(this.id);
        this.gui.partie();
    }

    public void jouer(String val, char coul)
    {
        this.work.jouer(this.id,val,coul);
    }

    public String getLastCarte()
    {
        return this.work.getLastCarte(this.id);
    }

    // public void setLastCarte(String val, String coul)
    // {
    //     this.gui.setLastCarte(val,coul);
    // }

    public void pioche()
    {
        
    }

    public void actualiserMesCartes()
    {
        this.gui.actualiserMesCartes();
    }

    public void exclure(String pseudo)
    {
        this.work.exclure(this.id,pseudo);
    }

    public void setPret(String pseudo)
    {
        this.work.setPret(this.id,pseudo);
    }

    public void PM(boolean b)
    {
        this.work.PM(this.id,b);
    }

    public void ST(boolean b)
    {
        this.work.ST(this.id,b);
    }

    public void PR(boolean b)
    {
        this.work.PR(this.id,b);
    }

    public void EQ(boolean b)
    {
        this.work.EQ(this.id,b);
    }

    public void nbCartesParJoueur(int n)
    {
        this.work.nbCartesParJoueur(this.id,n);
    }
}