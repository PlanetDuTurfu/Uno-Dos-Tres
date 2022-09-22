package sources.gui.lobby;

import sources.Controleur;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelLogo extends JPanel implements ActionListener
{
    private Controleur c;
    private float ratio;
    private JButton btnExclure;
    private JLabel lblImage;
    private String pseudo;

    public PanelLogo(Controleur c)
    {
        this.c = c;
        this.ratio = 1;
        this.pseudo = "personne";
        this.btnExclure = new JButton("Exclure");
        this.lblImage = new JLabel(new ImageIcon(new ImageIcon("./img/" + this.pseudo + ".jpg").getImage().getScaledInstance((int)(100*this.ratio),(int)(100*this.ratio), Image.SCALE_DEFAULT)));
        this.add(this.lblImage);
        this.btnExclure.addActionListener(this);

        this.setOpaque(false);
    }

    public void setLogo(String pseudo)
    {
        this.pseudo = pseudo;
        this.remove(this.lblImage);
        if (pseudo.length() > 2)
            if (pseudo.contains("BOT"))
                this.pseudo = "bot";
        this.lblImage = new JLabel(new ImageIcon(new ImageIcon("./img/" + this.pseudo + ".jpg").getImage().getScaledInstance((int)(108*this.ratio),(int)(108*this.ratio), Image.SCALE_DEFAULT)));
        this.pseudo = pseudo;
        this.add(this.lblImage);
        this.add(this.btnExclure);
    }

    public void setRatio(float ratio)
    {
        this.ratio = ratio;
        this.remove(this.lblImage);
        this.lblImage = new JLabel(new ImageIcon(new ImageIcon("./img/" + this.pseudo + ".jpg").getImage().getScaledInstance((int)(108*this.ratio),(int)(108*this.ratio), Image.SCALE_DEFAULT)));
        this.add(this.lblImage);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(this.btnExclure))
        {
            this.c.exclure(this.c.getID(), this.pseudo);
            this.pseudo = "personne";
            this.remove(this.btnExclure);
            this.remove(this.lblImage);
            this.lblImage = new JLabel(new ImageIcon(new ImageIcon("./img/" + this.pseudo + ".jpg").getImage().getScaledInstance((int)(108*this.ratio),(int)(108*this.ratio), Image.SCALE_DEFAULT)));
            this.add(this.lblImage);
        }

        this.c.resize();
    }

    public void removeBtn()
    {
        this.remove(this.btnExclure);
    }
}