package sources.gui;

import sources.Controleur;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelEchap extends JPanel implements ActionListener
{
    private Controleur c;
    private JComboBox<String> cbResolutions;
    private JButton btnBack;
    private JButton btnAppliquer;
    private boolean actif = false;

    public PanelEchap(Controleur c)
    {
        this.c = c;
        String[] resols  = {"1920x1080","1760x990","1600x900","1440x810","1280x720","1120x630"};
        this.cbResolutions = new JComboBox<>(resols);

        this.add(new JLabel("Resolution : "));
        this.add(this.cbResolutions);
        this.init(1);
        this.setOpaque(false);
    }

    public boolean estActif()
    {
        return this.actif;
    }

    public void plusActif()
    {
        this.actif = false;
    }

    public void setActif()
    {
        this.actif = true;
    }

    public void setRatio(float ratio)
    {
        this.remove(this.btnAppliquer);
        this.remove(this.btnBack);
        this.init(ratio);
    }

    private void init(float ratio)
    {
        this.btnAppliquer = new JButton(new ImageIcon(new ImageIcon("./img/appliquer.png").getImage().getScaledInstance((int)(384*ratio),(int)(216*ratio), Image.SCALE_DEFAULT)));
        this.btnBack = new JButton(new ImageIcon(new ImageIcon("./img/retour.png").getImage().getScaledInstance((int)(384*ratio),(int)(216*ratio), Image.SCALE_DEFAULT)));
        this.add(this.btnAppliquer);
        this.add(this.btnBack);
        this.btnAppliquer.setBorderPainted(false);
        this.btnAppliquer.setContentAreaFilled(false);
        this.btnBack.setBorderPainted(false);
        this.btnBack.setContentAreaFilled(false);
        this.btnAppliquer.addActionListener(this);
        this.btnBack.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        // Pour la résolution
        if (e.getSource().equals(this.btnAppliquer))
            this.c.setRatio(Float.parseFloat((this.cbResolutions.getSelectedItem()+"").split("x")[0]) / 1600);

        if (e.getSource().equals(this.btnBack)) this.c.echap();

        this.c.resize();
    }
}