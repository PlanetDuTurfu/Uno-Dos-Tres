package sources.gui.partie;

import sources.Controleur;
import sources.gui.partie.objets.ClientCarte;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
// import java.awt.GridLayout;

public class PanelL2 extends JPanel
{
    private Controleur c;
    private ClientCarte lastCarte;
    private PanelJ2 pnlJ2;
    private PanelJ4 pnlJ4;
    private JLabel trsp1;
    private JLabel trsp2;
    private float ratio = 1;

    public PanelL2(Controleur c)
    {
        this.c = c;
        this.pnlJ2 = new PanelJ2(c);
        this.pnlJ4 = new PanelJ4(c);
        // this.lastCarte = new ClientCarte("2",'B');
        this.trsp1 = new JLabel(new ImageIcon(new ImageIcon("./img/transparent.png").getImage().getScaledInstance((int)(192*ratio),(int)(108*ratio), Image.SCALE_DEFAULT)));
        this.trsp2 = new JLabel(new ImageIcon(new ImageIcon("./img/transparent.png").getImage().getScaledInstance((int)(192*ratio),(int)(108*ratio), Image.SCALE_DEFAULT)));
        this.setOpaque(false);
    }

    public void setRatio(float ratio)
    {
    }

    public void mettreEnPlace()
    {
        int indiceMoi = 0;
        String[] pseudos = this.c.getPseudos().split("¤");
        for (int i = 0; i < pseudos.length; i++)
            if (pseudos[i].equals(this.c.getPseudo())) indiceMoi = i;

        if (pseudos.length == 1) {}
        else if (pseudos.length == 2 || pseudos.length == 3)
        {
            if (indiceMoi == 0) this.pnlJ2.mettreEnPlace(pseudos[1]);
            if (indiceMoi == 1) this.pnlJ2.mettreEnPlace(pseudos[2]);
            if (indiceMoi == 2) this.pnlJ2.mettreEnPlace(pseudos[3]);
            if (indiceMoi == 3) this.pnlJ2.mettreEnPlace(pseudos[0]);
        }
        else if (pseudos.length == 4)
        {
            if (indiceMoi == 0)
            {
                this.pnlJ2.mettreEnPlace(pseudos[1]);
                this.pnlJ4.mettreEnPlace(pseudos[3]);
            }

            if (indiceMoi == 1)
            {
                this.pnlJ2.mettreEnPlace(pseudos[2]);
                this.pnlJ4.mettreEnPlace(pseudos[0]);
            }

            if (indiceMoi == 2)
            {
                this.pnlJ2.mettreEnPlace(pseudos[3]);
                this.pnlJ4.mettreEnPlace(pseudos[1]);
            }

            if (indiceMoi == 3)
            {
                this.pnlJ2.mettreEnPlace(pseudos[0]);
                this.pnlJ4.mettreEnPlace(pseudos[2]);
            }
        }

        this.lastCarte = new ClientCarte(this.c.getValLastCarte(),this.c.getCoulLastCarte());

        this.add(this.pnlJ2);
        this.add(this.trsp1);
        this.add(this.lastCarte);
        this.add(this.trsp2);
        this.add(this.pnlJ4);
    }
}