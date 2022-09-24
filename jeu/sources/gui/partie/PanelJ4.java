package sources.gui.partie;

import sources.Controleur;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;*/

public class PanelJ4 extends JPanel /*implements ActionListener*/
{
    private Controleur c;
    private JButton btnProfil;
    private JLabel nbCarte;
    private JLabel fleche;
    private String pseudo = "personne";
    private float ratio;

    public PanelJ4(Controleur c)
    {
        this.c = c;
        this.btnProfil = new JButton(new ImageIcon(new ImageIcon("./img/"+this.pseudo+".jpg").getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT)));
        this.nbCarte = new JLabel(new ImageIcon(new ImageIcon("./img/nb_carte/0.png").getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT)));
        this.fleche = new JLabel(new ImageIcon(new ImageIcon("./img/flechetrsp.png").getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT)));
        this.add(this.fleche);
        this.add(this.nbCarte);
        this.add(this.btnProfil);
        this.setOpaque(false);
    }

    public void setRatio(float ratio)
    {
        this.ratio = ratio;
        this.btnProfil = new JButton(new ImageIcon(new ImageIcon("./img/"+this.pseudo+".jpg").getImage().getScaledInstance((int)(100*this.ratio),(int)(100*this.ratio), Image.SCALE_DEFAULT)));
        this.nbCarte = new JLabel(new ImageIcon(new ImageIcon("./img/nb_carte/0.png").getImage().getScaledInstance((int)(100*this.ratio),(int)(100*this.ratio), Image.SCALE_DEFAULT)));
        this.fleche = new JLabel(new ImageIcon(new ImageIcon("./img/flechetrsp.png").getImage().getScaledInstance((int)(100*this.ratio),(int)(100*this.ratio), Image.SCALE_DEFAULT)));
    }

    public void mettreEnPlace(String pseudo)
    {
        this.pseudo = pseudo;
        if (pseudo.contains("BOT")) this.pseudo = "bot";
        this.btnProfil = new JButton(new ImageIcon(new ImageIcon("./img/"+this.pseudo+".jpg").getImage().getScaledInstance((int)(100*this.ratio),(int)(100*this.ratio), Image.SCALE_DEFAULT)));
        this.nbCarte = new JLabel(new ImageIcon(new ImageIcon("./img/nb_carte/0.png").getImage().getScaledInstance((int)(100*this.ratio),(int)(100*this.ratio), Image.SCALE_DEFAULT)));
        this.fleche = new JLabel(new ImageIcon(new ImageIcon("./img/flechetrsp.png").getImage().getScaledInstance((int)(100*this.ratio),(int)(100*this.ratio), Image.SCALE_DEFAULT)));
    }

    // public void actionPerformed(ActionEvent e)
    // {
    // }
}