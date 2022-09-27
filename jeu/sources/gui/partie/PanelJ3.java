package sources.gui.partie;

import sources.Controleur;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;*/

public class PanelJ3 extends JPanel /*implements ActionListener*/
{
    private Controleur c;
    private JButton btnProfil;
    private JLabel nbCarte;
    private JLabel fleche;
    private String pseudo = "personne";
    private float ratio = 1;
    private boolean partieCommencee = false;

    public PanelJ3(Controleur c)
    {
        this.c = c;
        this.setOpaque(false);
    }

    public void setRatio(float ratio)
    {
        this.ratio = ratio;
        if (this.partieCommencee)
        {
            this.remove(this.btnProfil);
            this.remove(this.nbCarte);
            this.remove(this.fleche);
            this.init();
        }
    }

    private void init()
    {
        String pseudTmp = this.pseudo;
        if (this.pseudo.contains("BOT")) this.pseudo = "bot";
        this.btnProfil = new JButton(new ImageIcon(new ImageIcon("./img/"+this.pseudo+".jpg").getImage().getScaledInstance((int)(100*this.ratio),(int)(100*this.ratio), Image.SCALE_DEFAULT)));
        this.pseudo = pseudTmp;
        int nbCarte = this.c.getNbCartes(this.pseudo);
        System.out.println("Carte de " + this.pseudo + " : " + nbCarte);
        String snbCartes = "";
        if (nbCarte < 16) snbCartes = "" + nbCarte;
        if (nbCarte > 15) snbCartes = "+++";
        if (nbCarte > 20) snbCartes = "bcp trop";
        if (nbCarte > 25) snbCartes = "chaud";
        if (nbCarte > 30) snbCartes = "record";
        this.nbCarte = new JLabel(new ImageIcon(new ImageIcon("./img/nb_cartes/"+snbCartes+".png").getImage().getScaledInstance((int)(54*this.ratio),(int)(96*this.ratio), Image.SCALE_DEFAULT)));
        this.fleche = new JLabel(new ImageIcon(new ImageIcon("./img/flechetrsp.png").getImage().getScaledInstance((int)(100*this.ratio),(int)(100*this.ratio), Image.SCALE_DEFAULT)));
        this.btnProfil.setBorderPainted(false);
        this.btnProfil.setContentAreaFilled(false);
        this.add(this.btnProfil);
        this.add(this.nbCarte);
        this.add(this.fleche);
    }

    public void mettreEnPlace(String pseudo)
    {
        this.partieCommencee = true;
        this.pseudo = pseudo;
        this.init();
    }

    // public void actionPerformed(ActionEvent e)
    // {
    // }
}