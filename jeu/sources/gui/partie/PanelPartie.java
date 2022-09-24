package sources.gui.partie;

import sources.Controleur;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPartie extends JPanel implements ActionListener
{
    private Controleur c;
    private PanelJ1 pnlJ1;
    private PanelJ2 pnlJ2;
    private PanelJ3 pnlJ3;
    private PanelJ4 pnlJ4;

    public PanelPartie(Controleur c)
    {
        this.c = c;
        this.pnlJ1 = new PanelJ1(c);
        this.pnlJ2 = new PanelJ2(c);
        this.pnlJ3 = new PanelJ3(c);
        this.pnlJ4 = new PanelJ4(c);
        this.setOpaque(false);
    }

    public void setRatio(float ratio)
    {
    }

    public void mettreEnPlace()
    {
        int indiceMoi = 0;
        String[] pseudos = this.c.getPseudos(this.c.getID()).split("¤");
        if (pseudos[0].equals(this.c.getPseudo())) indiceMoi = 0;
        if (pseudos[1].equals(this.c.getPseudo())) indiceMoi = 1;
        if (pseudos[2].equals(this.c.getPseudo())) indiceMoi = 2;
        if (pseudos[3].equals(this.c.getPseudo())) indiceMoi = 3;

        if (indiceMoi == 0)
        {
            this.pnlJ1.mettreEnPlace(pseudos[0]);
            this.pnlJ2.mettreEnPlace(pseudos[1]);
            this.pnlJ3.mettreEnPlace(pseudos[2]);
            this.pnlJ4.mettreEnPlace(pseudos[3]);
        }

        if (indiceMoi == 1)
        {
            this.pnlJ1.mettreEnPlace(pseudos[1]);
            this.pnlJ2.mettreEnPlace(pseudos[2]);
            this.pnlJ3.mettreEnPlace(pseudos[3]);
            this.pnlJ4.mettreEnPlace(pseudos[0]);
        }

        if (indiceMoi == 2)
        {
            this.pnlJ1.mettreEnPlace(pseudos[2]);
            this.pnlJ2.mettreEnPlace(pseudos[3]);
            this.pnlJ3.mettreEnPlace(pseudos[0]);
            this.pnlJ4.mettreEnPlace(pseudos[1]);
        }

        if (indiceMoi == 3)
        {
            this.pnlJ1.mettreEnPlace(pseudos[3]);
            this.pnlJ2.mettreEnPlace(pseudos[0]);
            this.pnlJ3.mettreEnPlace(pseudos[1]);
            this.pnlJ4.mettreEnPlace(pseudos[2]);
        }
    }

    public void pret()
    {
        this.c.setPret(this.c.getID(),this.c.getPseudo());
    }

    public void actionPerformed(ActionEvent e)
    {
    }
}