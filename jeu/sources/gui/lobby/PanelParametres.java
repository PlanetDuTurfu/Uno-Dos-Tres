package sources.gui.lobby;

import sources.Controleur;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class PanelParametres extends JPanel
{
    private Controleur c;
    private PanelP1 pnlP1;
    // private PanelP2 pnlP2;
    private PanelP3 pnlP3;

    public PanelParametres(Controleur c)
    {
        this.c = c;
        this.setLayout(new GridLayout(2,1,0,50));
        this.pnlP1 = new PanelP1(c);
        this.pnlP3 = new PanelP3(c);

        this.add(this.pnlP1);
        // this.add(this.pnlP2);
        this.add(this.pnlP3);

        this.setOpaque(false);
    }

    public void setRatio(float ratio)
    {
        this.pnlP1.setRatio(ratio);
        this.pnlP3.setRatio(ratio);
        this.remove(this.pnlP1);
        this.remove(this.pnlP3);
        this.setLayout(new GridLayout(2,1,0,(int)(50*ratio)));
        this.add(this.pnlP1);
        this.add(this.pnlP3);
    }

    public void reinitialiserParam()
	{
		this.pnlP1.reinitialiserParam();
	}
}