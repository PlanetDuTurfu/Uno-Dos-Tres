package sources.gui.partie;

import sources.Controleur;
import sources.gui.partie.objets.ClientCarte;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.ArrayList;

public class PanelJ1 extends JPanel
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
        // this.removeBtn();
        this.mettreEnPlace(this.pseudo);
    }

    public void mettreEnPlace(String pseudo)
    {
        this.pseudo = pseudo;
        String[] tmpCartes = this.c.getCartes(this.pseudo);
        for (String s : tmpCartes)
        {
            s = s.replace("[","");
            s = s.replace("]","");
            this.cartes.add(new ClientCarte(this.c, s.split(" ")[0],s.split(" ")[1].charAt(0), false, this.ratio));
        }

        this.setLayout(new GridLayout(1,this.cartes.size(),0,0));
        for (ClientCarte cc : this.cartes) this.add(cc);
    }

    // private void removeBtn()
    // {
    //     this.removeAll();
    //     // for (ClientCarte cc : this.cartes)
    //     //     this.remove(cc);
    // }

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

    // public void actualiserMesCartes()
    // {
    //     this.removeBtn();
    //     this.mettreEnPlace(this.pseudo);
    //     this.c.resize();
    // }
}