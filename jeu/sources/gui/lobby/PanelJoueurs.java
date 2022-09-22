package sources.gui.lobby;

import sources.Controleur;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelJoueurs extends JPanel implements ActionListener
{
    private Controleur c;
    private String id;

    public PanelJoueurs(Controleur c)
    {
        this.c = c;

        this.setOpaque(false);
    }

    public void setID(String id)
    {
        this.id = id;
        this.add(new JLabel(this.id));
    }

    public void actionPerformed(ActionEvent e)
    {
        if (this.c.getNbJoueurs(this.id) == 4) return;
        else this.c.addBot(this.id);
    }
}