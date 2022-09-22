package sources.gui;

import sources.Controleur;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelLobby extends JPanel implements ActionListener
{
    private Controleur c;
    private JComboBox<String> cbResolutions;
    private JButton btnGo;
    private JButton btnAppliquer;

    public PanelLobby(Controleur c)
    {
        this.c = c;

        this.setOpaque(false);
    }

    public void actionPerformed(ActionEvent e)
    {
    }
}