package sources.gui.partie.objets;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientCarte extends JPanel implements ActionListener
{
    private boolean jouable;
    private String val;
    private char coul;
    private JButton btnCarte;

    public ClientCarte(String val, char coul)
    {
        this.jouable = false;
        this.val = val;
        this.coul = coul;
        this.btnCarte = new JButton(new ImageIcon(new ImageIcon("./img/cartes/"+val+coul+".jpg").getImage().getScaledInstance(54,96, Image.SCALE_DEFAULT)));
        this.btnCarte.setBorderPainted(false);
        this.btnCarte.setContentAreaFilled(false);
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

    }
}