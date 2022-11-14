package sources.gui.partie.objets;

import sources.Controleur;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientCarte extends JPanel implements ActionListener
{
    private Controleur c;
    private boolean jouable;
    private String val;
    private char coul;
    private JButton btnCarte;
    private JLabel trsp;

    public ClientCarte(Controleur c, String val, char coul, boolean deco, float ratio)
    {
        this.c = c;
        if (ratio == 0) ratio = 1;
        this.jouable = false;
        this.val = val;
        this.coul = coul;
        this.btnCarte = new JButton(new ImageIcon(new ImageIcon("./img/cartes/"+val+coul+".jpg").getImage().getScaledInstance((int)(ratio*108),(int)(ratio*192), Image.SCALE_DEFAULT)));
        this.btnCarte.setBorderPainted(false);
        this.btnCarte.setContentAreaFilled(false);
        if (!deco) {
            this.trsp = new JLabel(new ImageIcon(new ImageIcon("./img/transparent.png").getImage().getScaledInstance((int)(ratio*5),(int)(ratio*2), Image.SCALE_DEFAULT)));
            this.add(this.trsp);
            this.btnCarte.addActionListener(this);
        }
        this.add(this.btnCarte);
        this.setOpaque(false);
    }

    public void jouable(boolean b)
    {
        this.jouable = b;
        this.btnCarte.addActionListener(this);
    }

    public boolean estJouable()
    {
        return this.jouable;
    }

    public String getVal()
    {
        return this.val;
    }

    public char getCoul()
    {
        return this.coul;
    }

    public String toString()
    {
        return "<" + this.val + " " + this.coul + ">";
    }

    public void actionPerformed(ActionEvent e)
    {
        this.c.jouer(this.getVal(), this.getCoul());
        this.c.actualiserMesCartes();
    }
}