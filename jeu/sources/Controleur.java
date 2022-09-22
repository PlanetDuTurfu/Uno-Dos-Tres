package sources;

import sources.worker.Worker;
import sources.gui.Frame;

public class Controleur
{
    private Worker work;
    private Frame gui;

    public Controleur()
    {
        // String[] s = new String[3];
        // s[0] = "BOT a";
        // s[1] = "BOT b";
        // s[2] = "BOT c";
        // this.work = new Worker(s);
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
}