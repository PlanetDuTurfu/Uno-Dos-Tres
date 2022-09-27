package sources.gui.partie;

import sources.Controleur;
import sources.gui.partie.objets.ClientCarte;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.GridLayout;
/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;*/
import java.util.ArrayList;

public class PanelJ1 extends JPanel /*implements ActionListener*/
{
    private Controleur c;
    private String pseudo = "personne";
    private float ratio;
    private ArrayList<ClientCarte> cartes;

    public PanelJ1(Controleur c)
    {
        this.c = c;
        this.cartes = new ArrayList<ClientCarte>();
        this.setOpaque(false);
    }

    public void setRatio(float ratio)
    {
        this.ratio = ratio;
    }

    public void mettreEnPlace(String pseudo)
    {
        this.pseudo = pseudo;
        String[] tmpCartes = this.c.getCartes(this.pseudo);
        for (String s : tmpCartes)
        {
            s = s.replace("[","");
            s = s.replace("]","");
            this.cartes.add(new ClientCarte(s.split(" ")[0],s.split(" ")[1].charAt(0)));
        }
        this.setLayout(new GridLayout(this.cartes.size(),1));
        for (ClientCarte cc : this.cartes)
        {
            this.add(cc);
            System.out.println("added ./img/cartes/"+cc.getVal()+""+cc.getCoul()+".jpg");
        }
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