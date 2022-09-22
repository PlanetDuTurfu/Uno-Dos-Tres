package sources.gui;

import sources.Controleur;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.GridLayout;

public class PanelAccueil extends JPanel implements ActionListener
{
    private Controleur c;
    private JButton btnLobby;
    private JButton btnParam;
    private JButton btnLeave;
    private JLabel trsp1;
    private JLabel trsp2;
    private JLabel trsp3;
    private JLabel trsp4;

    public PanelAccueil(Controleur c, float ratio)
    {
        this.c = c;
        this.init(ratio);
        this.setOpaque(false);
    }

    private void init(float ratio)
    {
        this.setLayout(new GridLayout(3,2,(int)(150*ratio),(int)(85*ratio/1.15)));
        this.btnLobby = new JButton(new ImageIcon(new ImageIcon("./img/creer.png").getImage().getScaledInstance((int)(384*ratio),(int)(216*ratio), Image.SCALE_DEFAULT)));
        this.btnParam = new JButton(new ImageIcon(new ImageIcon("./img/parametres.png").getImage().getScaledInstance((int)(384*ratio),(int)(216*ratio), Image.SCALE_DEFAULT)));
        this.btnLeave = new JButton(new ImageIcon(new ImageIcon("./img/quitter.png").getImage().getScaledInstance((int)(384*ratio),(int)(216*ratio), Image.SCALE_DEFAULT)));
        this.trsp1 = new JLabel(new ImageIcon(new ImageIcon("./img/transparent.png").getImage().getScaledInstance((int)(384*ratio/1.5),(int)(216*ratio/1.3), Image.SCALE_DEFAULT)));
        this.trsp2 = new JLabel(new ImageIcon(new ImageIcon("./img/transparent.png").getImage().getScaledInstance((int)(384*ratio/1.5),(int)(216*ratio/1.3), Image.SCALE_DEFAULT)));
        this.trsp3 = new JLabel(new ImageIcon(new ImageIcon("./img/transparent.png").getImage().getScaledInstance((int)(384*ratio/1.5),(int)(216*ratio/1.3), Image.SCALE_DEFAULT)));
        this.trsp4 = new JLabel(new ImageIcon(new ImageIcon("./img/transparent.png").getImage().getScaledInstance((int)(384*ratio/1.5),(int)(216*ratio/1.3), Image.SCALE_DEFAULT)));
        this.btnLobby.setBorderPainted(false);
        this.btnParam.setBorderPainted(false);
        this.btnLeave.setBorderPainted(false);
        this.btnLobby.setContentAreaFilled(false);
        this.btnParam.setContentAreaFilled(false);
        this.btnLeave.setContentAreaFilled(false);
        this.add(this.btnLobby);
        this.add(this.trsp1);
        this.add(this.trsp2);
        this.add(this.btnParam);
        this.add(this.trsp3);
        this.add(this.trsp4);
        this.add(this.btnLeave);
        this.btnLobby.addActionListener(this);
        this.btnParam.addActionListener(this);
        this.btnLeave.addActionListener(this);
    }

    public void setRatio(float ratio)
    {
        this.remove(this.btnLobby);
        this.remove(this.btnParam);
        this.remove(this.btnLeave);
        this.remove(this.trsp1);
        this.remove(this.trsp2);
        this.remove(this.trsp3);
        this.remove(this.trsp4);
        this.init(ratio);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(this.btnLobby)) this.c.lobby();
        if (e.getSource().equals(this.btnParam)) this.c.echap();
        if (e.getSource().equals(this.btnLeave)) this.c.leave();
    }
}