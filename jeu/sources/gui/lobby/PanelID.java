package sources.gui.lobby;

import sources.Controleur;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class PanelID extends JPanel implements ActionListener
{
    private Controleur c;
    private float ratio = 1;
    private boolean afficheID = false;
    private JButton btnCopierID;
    private JButton btnID;
    private JLabel trsp1;

    public PanelID(Controleur c)
    {
        this.setLayout(new GridLayout(2,2,30,550));
        this.c = c;
        this.init();
        this.setOpaque(false);
    }

    public void setRatio(float ratio)
    {
        this.ratio = ratio;
        this.removeTout();
        this.setLayout(new GridLayout(2,2,(int)(50*ratio),(int)(550*ratio)));
        this.init();
    }

    private void init()
    {
        this.btnCopierID = new JButton(new ImageIcon(new ImageIcon("./img/copierID.png").getImage().getScaledInstance((int)(144*ratio),(int)(81*ratio), Image.SCALE_DEFAULT)));
        if (this.afficheID) this.btnID = new JButton(this.c.getID(), new ImageIcon(new ImageIcon("./img/imgID.png").getImage().getScaledInstance((int)(144*this.ratio),(int)(81*this.ratio), Image.SCALE_DEFAULT)));
        else this.btnID = new JButton(new ImageIcon(new ImageIcon("./img/eee.png").getImage().getScaledInstance((int)(144*this.ratio),(int)(81*this.ratio), Image.SCALE_DEFAULT)));
        this.trsp1 = new JLabel(new ImageIcon(new ImageIcon("./img/transparent.png").getImage().getScaledInstance((int)(144*ratio),(int)(81*ratio), Image.SCALE_DEFAULT)));
        this.add(this.btnCopierID);
        this.add(this.btnID);
        this.add(this.trsp1);
        this.btnCopierID.addActionListener(this);
        this.btnCopierID.setBorderPainted(false);
        this.btnCopierID.setContentAreaFilled(false);
        this.btnID.addActionListener(this);
        this.btnID.setBorderPainted(false);
        this.btnID.setContentAreaFilled(false);
    }

    private void removeTout()
    {
        this.remove(this.btnCopierID);
        this.remove(this.btnID);
        this.remove(this.trsp1);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(this.btnCopierID))
        {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection data = new StringSelection(this.c.getID());
            clipboard.setContents(data, data);
        }
        else
        {
            this.afficheID = !this.afficheID;
            this.removeTout();
            if (this.afficheID)
                this.btnID = new JButton(this.c.getID(),new ImageIcon(new ImageIcon("./img/imgID.png").getImage().getScaledInstance((int)(144*this.ratio),(int)(81*this.ratio), Image.SCALE_DEFAULT)));
            else
                this.btnID = new JButton(new ImageIcon(new ImageIcon("./img/eee.png").getImage().getScaledInstance((int)(144*this.ratio),(int)(81*this.ratio), Image.SCALE_DEFAULT)));
            this.init();
        }
    }

    @Override
    protected void paintComponent(final Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(new ImageIcon(new ImageIcon("./img/imgID.png").getImage().getScaledInstance(this.getWidth(),this.getHeight()/8, Image.SCALE_DEFAULT)).getImage(), 0, 0, null);
    }
}