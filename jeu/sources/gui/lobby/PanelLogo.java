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
    private JButton btnExclure;
    private JLabel lblImage;
    private String pseudo;
    private float ratio = 1;

    public PanelLogo(Controleur c)
    {
        this.c = c;
        this.pseudo = "personne";
        this.btnExclure = new JButton("Exclure");
        this.init();
        this.setOpaque(false);
    }

    public void setLogo(String pseudo)
    {
        this.pseudo = pseudo;
        if (pseudo.length() > 2)
            if (pseudo.contains("BOT"))
                this.pseudo = "bot";
        this.init();
        if (!pseudo.equals("personne") && !pseudo.equals(this.c.getPseudo()))
        {
            this.add(this.btnExclure);
            this.btnExclure.addActionListener(this);
        }
        this.pseudo = pseudo;
    }

    public void setRatio(float ratio)
    {
        this.ratio = ratio;
        this.init();
    }

    private void init()
    {
        if (this.lblImage != null) this.remove(this.lblImage);
        this.lblImage = new JLabel(new ImageIcon(new ImageIcon("./img/" + this.pseudo + ".jpg").getImage().getScaledInstance((int)(108*this.ratio),(int)(108*this.ratio), Image.SCALE_DEFAULT)));
        this.add(this.lblImage);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(this.btnExclure))
        {
            this.c.exclure(this.pseudo);
            this.pseudo = "personne";
            this.remove(this.btnExclure);
            this.init();
        }

        this.c.resize();
    }

    public void removeBtn()
    {
        this.remove(this.btnExclure);
    }
}