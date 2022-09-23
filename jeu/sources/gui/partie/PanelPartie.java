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

    public PanelPartie(Controleur c)
    {
        this.c = c;
        this.setOpaque(false);
    }

    public void setRatio(float ratio)
    {
    }

    public void pret()
    {
        this.c.setPret(this.c.getID(),this.c.getPseudo());
    }

    public void actionPerformed(ActionEvent e)
    {
    }
}