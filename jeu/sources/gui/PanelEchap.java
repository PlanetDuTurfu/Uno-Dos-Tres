package sources.gui;

import sources.Controleur;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelEchap extends JPanel implements ActionListener
{
    private Controleur c;
    private JComboBox<String> cbResolutions;
    private JButton btnGo;
    private JButton btnAppliquer;

    public PanelEchap(Controleur c)
    {
        this.c = c;
        String[] resols  = {"1920x1080","1760x990","1600x900","1440x810","1280x720","1120x630"};
        this.cbResolutions = new JComboBox<>(resols);
        this.btnAppliquer = new JButton("Appliquer les modifications !");
        this.btnGo = new JButton("Retour au jeu !");

        this.add(new JLabel("Resolution : "));
        this.add(this.cbResolutions);
        this.add(this.btnAppliquer);
        this.add(this.btnGo);

        this.btnAppliquer.addActionListener(this);
        this.btnGo.addActionListener(this);
        this.setOpaque(false);
    }

    public void actionPerformed(ActionEvent e)
    {
        // Pour la résolution
        if (e.getSource().equals(this.btnAppliquer))
            this.c.setRatio(Float.parseFloat((this.cbResolutions.getSelectedItem()+"").split("x")[0]) / 1600);

        if (e.getSource().equals(this.btnGo)) this.c.backToGame();

        this.c.resize();
    }
}