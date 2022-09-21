package sources;

import sources.worker.Worker;
import sources.gui.Frame;

public class Controleur
{
    private Worker work;
    private Frame gui;

    public Controleur()
    {
        String[] s = new String[4];
        s[0] = "a";
        s[1] = "b";
        s[2] = "c";
        s[3] = "d";
        this.work = new Worker(s);
        this.gui = new Frame(this);
    }

    public void demarrer()
    {
        this.work.demarrer();
        this.gui.demarrer();
    }

    public void setRatio(float ratio)
    {
        this.gui.setRatio(ratio);
    }

    public void echap()
    {
        this.gui.echap();
    }

    public void backToGame()
    {
        this.gui.backToGame();
    }

    public void resize()
    {
        this.gui.resize();
    }
}