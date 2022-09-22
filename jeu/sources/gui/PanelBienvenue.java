package sources.gui;

import sources.Controleur;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class PanelBienvenue extends JPanel implements MouseListener
{
    private Controleur c;
    private JLabel lblImage;

    public PanelBienvenue(Controleur c)
    {
        this.c = c;
        this.lblImage = new JLabel(new ImageIcon(new ImageIcon("./img/uno_dos_tres_cliquez.jpg").getImage().getScaledInstance((int)(1600),(int)(900), Image.SCALE_DEFAULT)));
        this.add(this.lblImage);
        this.addMouseListener(this);
    }

    public void mouseExited  (MouseEvent e) {}
    public void mousePressed (MouseEvent e) {}
    public void mouseClicked (MouseEvent e) {}
    public void mouseEntered (MouseEvent e) {}
    public void mouseReleased(MouseEvent e)
    {
        this.c.accueil();
    }
}