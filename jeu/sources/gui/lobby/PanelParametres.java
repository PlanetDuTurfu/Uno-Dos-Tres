package sources.gui.lobby;

import sources.Controleur;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelParametres extends JPanel implements ActionListener
{
    private Controleur c;

    public PanelParametres(Controleur c)
    {
        this.c = c;
    }

    public void setRatio(float ratio)
    {
    }

    public void actionPerformed(ActionEvent e)
    {
    }
}