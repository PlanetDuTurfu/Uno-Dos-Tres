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
    private PanelID pnlID;
    private PanelParametres pnlParam;
    private JButton btnBack;
    private JLabel trsp1;

    public PanelLobby(Controleur c)
    {
        this.c = c;
        this.pnlJoueurs = new PanelJoueurs(c);
        this.pnlID = new PanelID(c);
        this.pnlParam = new PanelParametres(c);
        this.init(1);
        this.setOpaque(false);
    }

    public void setRatio(float ratio)
    {
        this.remove(this.btnBack);
        this.remove(this.pnlJoueurs);
        this.remove(this.pnlID);
        this.remove(this.trsp1);
        this.remove(this.pnlParam);
        this.init(ratio);
        this.pnlJoueurs.setRatio(ratio);
        this.pnlID.setRatio(ratio);
        this.pnlParam.setRatio(ratio);
    }

    private void init(float ratio)
    {
        this.btnBack = new JButton(new ImageIcon(new ImageIcon("./img/back.png").getImage().getScaledInstance((int)(100*ratio),(int)(100*ratio), Image.SCALE_DEFAULT)));
        this.trsp1 = new JLabel(new ImageIcon(new ImageIcon("./img/transparent.png").getImage().getScaledInstance((int)(384*ratio),(int)(216*ratio), Image.SCALE_DEFAULT)));
        this.add(this.btnBack);
        this.add(this.pnlJoueurs);
        this.add(this.pnlID);
        this.add(this.trsp1);
        this.add(this.pnlParam);
        this.btnBack.addActionListener(this);
        this.btnBack.setBorderPainted(false);
        this.btnBack.setContentAreaFilled(false);
    }

    public void reinitialiserParam()
	{
		this.pnlParam.reinitialiserParam();
	}

    public void actionPerformed(ActionEvent e)
    {
        this.pnlJoueurs.reinitialiser();
        this.c.accueil();
    }
}