package sources.gui.partie;

import sources.Controleur;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;*/

public class PanelJ1 extends JPanel /*implements ActionListener*/
{
    private Controleur c;
    private String pseudo = "personne";
    private float ratio;

    public PanelJ1(Controleur c)
    {
        this.c = c;
        this.setOpaque(false);
    }

    public void setRatio(float ratio)
    {
        this.ratio = ratio;
    }

    public void mettreEnPlace(String pseudo)
    {
        this.pseudo = pseudo;
    }

    // public void carteJouable(String cartes)
    // {
    //     String[] indices = cartes.split(" ");
    //     for (String s : indices)
    //     {
    //         this.monter(this.cartes.get(Integer.parseInt(s)));
    //         // this.cartes.get(Integer.parseInt(s)).addActionListener(this);
    //     }
    // }

    // private void monter(ImgCarte c)
    // {

    // }

    // public void actionPerformed(ActionEvent e)
    // {
    // }
}