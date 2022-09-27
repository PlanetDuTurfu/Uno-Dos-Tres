package sources.gui.lobby;

import sources.Controleur;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelP3 extends JPanel implements ActionListener
{
    private Controleur c;
    private JButton btnLancer;
	private JButton btnReinitialiser;
    private boolean dejaLance = false;

    public PanelP3(Controleur c)
    {
        this.c = c;
        this.setLayout(new GridLayout(2,1,0,0));
        this.init(1);
        this.btnReinitialiser.addActionListener(this);
        this.btnLancer.addActionListener(this);
        this.setOpaque(false);
    }

    public void setRatio(float ratio)
    {
        this.remove(this.btnReinitialiser);
        this.remove(this.btnLancer);
        this.init(ratio);
    }

    private void init(float ratio)
    {
        this.btnReinitialiser = new JButton(new ImageIcon(new ImageIcon("./img/reinitialiser.png").getImage().getScaledInstance((int)(192*ratio),(int)(108*ratio), Image.SCALE_DEFAULT)));
        this.btnLancer = new JButton(new ImageIcon(new ImageIcon("./img/lancer.png").getImage().getScaledInstance((int)(288*ratio),(int)(162*ratio), Image.SCALE_DEFAULT)));
        this.add(this.btnReinitialiser);
        this.add(this.btnLancer);
        this.btnReinitialiser.addActionListener(this);
        this.btnReinitialiser.setBorderPainted(false);
        this.btnReinitialiser.setContentAreaFilled(false);
        this.btnLancer.addActionListener(this);
        this.btnLancer.setBorderPainted(false);
        this.btnLancer.setContentAreaFilled(false);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(this.btnLancer) && !this.dejaLance)
        {
            this.dejaLance = true;
            this.c.lancerPartie();
        }
        else if (e.getSource().equals(this.btnReinitialiser)) this.c.reinitialiserParam();
    }
}