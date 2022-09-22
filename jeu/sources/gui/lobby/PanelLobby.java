package sources.gui.lobby;

import sources.Controleur;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelLobby extends JPanel implements ActionListener
{
    private Controleur c;
    private PanelJoueurs pnlJoueurs;
    private PanelParametres pnlParam;
    private JButton btnBack;

    public PanelLobby(Controleur c)
    {
        this.c = c;

        this.btnBack = new JButton(new ImageIcon(new ImageIcon("./img/back.png").getImage().getScaledInstance((int)(100),(int)(100), Image.SCALE_DEFAULT)));
        this.pnlJoueurs = new PanelJoueurs(c);
        this.pnlParam = new PanelParametres(c);
        this.add(this.btnBack);
        this.add(this.pnlJoueurs);
        this.add(this.pnlParam);

        this.btnBack.addActionListener(this);
        this.btnBack.setBorderPainted(false);
        this.btnBack.setContentAreaFilled(false);

        this.setOpaque(false);
    }

    public void setRatio(float ratio)
    {
        this.pnlJoueurs.setRatio(ratio);
    }

    public void actionPerformed(ActionEvent e)
    {
        this.pnlJoueurs.reinitialiser();
        this.c.accueil();
    }
}