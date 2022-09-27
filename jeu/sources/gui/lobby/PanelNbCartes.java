package sources.gui.lobby;

import sources.Controleur;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelNbCartes extends JPanel implements ActionListener
{
    private Controleur c;
    private JButton btnPlus;
	private JButton btnMoins;
    private JLabel lblNbCartes;
    private float ratio = 1;
    private int nbCartesParJoueur = 7;

    public PanelNbCartes(Controleur c)
    {
        this.c = c;
        this.setLayout(new GridLayout(1,3,0,0));
        this.init();
        this.setOpaque(false);
    }

    public void setRatio(float ratio)
    {
        this.ratio = ratio;
        this.remove(this.btnPlus);
        this.remove(this.btnMoins);
        this.init();
    }

    private void removeBtn()
    {
        this.remove(this.btnMoins);
        this.remove(this.btnPlus);
        this.remove(this.lblNbCartes);
    }

    private void init()
    {
        this.btnMoins = new JButton(new ImageIcon(new ImageIcon("./img/moins.png").getImage().getScaledInstance((int)(54*ratio),(int)(96*ratio), Image.SCALE_DEFAULT)));
        this.btnPlus = new JButton(new ImageIcon(new ImageIcon("./img/plus.png").getImage().getScaledInstance((int)(54*ratio),(int)(96*ratio), Image.SCALE_DEFAULT)));
        String snbCartes = "";
        if (this.nbCartesParJoueur < 16) snbCartes = "" + this.nbCartesParJoueur;
        if (this.nbCartesParJoueur > 15) snbCartes = "+++";
        if (this.nbCartesParJoueur > 20) snbCartes = "bcp trop";
        if (this.nbCartesParJoueur > 25) snbCartes = "chaud";
        if (this.nbCartesParJoueur > 30) snbCartes = "record";
        this.lblNbCartes = new JLabel(new ImageIcon(new ImageIcon("./img/nb_cartes/"+snbCartes+".png").getImage().getScaledInstance((int)(54*this.ratio),(int)(96*this.ratio), Image.SCALE_DEFAULT)));;
        this.add(this.btnMoins);
        this.add(this.lblNbCartes);
        this.add(this.btnPlus);
        this.btnMoins.addActionListener(this);
        this.btnMoins.setBorderPainted(false);
        this.btnMoins.setContentAreaFilled(false);
        this.btnPlus.addActionListener(this);
        this.btnPlus.setBorderPainted(false);
        this.btnPlus.setContentAreaFilled(false);
    }

    public void reinitialiser()
    {
        this.nbCartesParJoueur = 7;
        this.removeBtn();
        this.init();
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(this.btnPlus)) this.c.nbCartesParJoueur(++this.nbCartesParJoueur);
        else this.c.nbCartesParJoueur(--this.nbCartesParJoueur);
        this.removeBtn();
        this.init();
    }
}