package sources.gui.partie;

import sources.Controleur;
import sources.gui.partie.objets.ClientCarte;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class PanelPartie extends JPanel
{
    private Controleur c;
    private PanelL1 pnlL1;
    private PanelL2 pnlL2;
    private PanelJ1 pnlJ1;
    private float ratio = 1;

    public PanelPartie(Controleur c)
    {
        this.c = c;
        this.setLayout(new GridLayout(3,1));
        this.pnlL1 = new PanelL1(c);
        this.pnlL2 = new PanelL2(c);
        this.pnlJ1 = new PanelJ1(c);
        this.setOpaque(false);
    }

    public void setRatio(float ratio)
    {
        this.pnlL1.setRatio(ratio);
        this.pnlL2.setRatio(ratio);
        this.pnlJ1.setRatio(ratio);
    }

    public void mettreEnPlace()
    {
        this.pnlL1.mettreEnPlace();
        this.pnlL2.mettreEnPlace();
        String[] pseudos = this.c.getPseudos().split("¤");
        if (pseudos[0].equals(this.c.getPseudo())) this.pnlJ1.mettreEnPlace(pseudos[0]);
        else if (pseudos[1].equals(this.c.getPseudo())) this.pnlJ1.mettreEnPlace(pseudos[1]);
        else if (pseudos[2].equals(this.c.getPseudo())) this.pnlJ1.mettreEnPlace(pseudos[2]);
        else if (pseudos[3].equals(this.c.getPseudo())) this.pnlJ1.mettreEnPlace(pseudos[3]);
        this.add(this.pnlL1);
        this.add(this.pnlL2);
        this.add(this.pnlJ1);
    }
}