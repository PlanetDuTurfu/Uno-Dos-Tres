package sources.gui.lobby;

import sources.Controleur;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class PanelLobby extends JPanel
{
    private String id;
    private Controleur c;
    private PanelJoueurs pnlJoueurs;

    public PanelLobby(Controleur c)
    {
        this.c = c;

        this.pnlJoueurs = new PanelJoueurs(c);
        this.add(this.pnlJoueurs);

        this.setOpaque(false);
    }

    public void setID(String id)
    {
        this.id = id;
        this.pnlJoueurs.setID(id);
    }
}