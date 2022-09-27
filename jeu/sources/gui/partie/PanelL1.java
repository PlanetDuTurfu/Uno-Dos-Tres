package sources.gui.partie;

import sources.Controleur;
import sources.gui.partie.objets.ClientCarte;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
// import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelL1 extends JPanel implements ActionListener
{
    private Controleur c;
    private JButton pioche;
    private JButton parametres;
    private PanelJ3 pnlJ3;
    private JLabel trsp1;
    private JLabel trsp2;
    private float ratio = 1;

    public PanelL1(Controleur c)
    {
        this.c = c;
        // this.setLayout(new GridLayout(3,1));
        this.pnlJ3 = new PanelJ3(c);
        this.pioche = new JButton(new ImageIcon(new ImageIcon("./img/imgID.png").getImage().getScaledInstance(108,192, Image.SCALE_DEFAULT)));
        this.parametres = new JButton(new ImageIcon(new ImageIcon("./img/parametres.png").getImage().getScaledInstance(192,108, Image.SCALE_DEFAULT)));
        this.trsp1 = new JLabel(new ImageIcon(new ImageIcon("./img/transparent.png").getImage().getScaledInstance((int)(192*ratio),(int)(108*ratio), Image.SCALE_DEFAULT)));
        this.trsp2 = new JLabel(new ImageIcon(new ImageIcon("./img/transparent.png").getImage().getScaledInstance((int)(192*ratio),(int)(108*ratio), Image.SCALE_DEFAULT)));
        this.pioche.setBorderPainted(false);
        this.pioche.setContentAreaFilled(false);
        this.parametres.setBorderPainted(false);
        this.parametres.setContentAreaFilled(false);
        this.setOpaque(false);
    }

    public void setRatio(float ratio)
    {
    }

    public void mettreEnPlace()
    {
        int indiceLui = 0;
        String[] pseudos = this.c.getPseudos().split("¤");
        for (int i = 0; i < pseudos.length; i++)
            if (pseudos[i].equals(this.c.getPseudo())) indiceLui = (i + 2) % pseudos.length;

        if (pseudos.length == 1) {}
        else if (pseudos.length == 3 || pseudos.length == 4)
            this.pnlJ3.mettreEnPlace(pseudos[indiceLui]);

        this.add(this.pioche);
        this.add(this.trsp1);
        this.add(this.pnlJ3);
        this.add(this.trsp2);
        this.add(this.parametres);
        this.parametres.addActionListener(this);
    }

    public void monTour()
    {
        this.pioche.addActionListener(this);
    }

    public void plusMonTour()
    {
        for (ActionListener al : this.pioche.getActionListeners())
            this.pioche.removeActionListener(al);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(this.parametres)) this.c.echap();
        else if (e.getSource().equals(this.pioche)) this.c.pioche();
    }
}