package sources.gui;

import sources.Controleur;
import sources.gui.lobby.PanelLobby;
import sources.gui.partie.PanelPartie;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JRootPane;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.Image;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame
{
	private Controleur c;
	private float ratio = 1;
	private PanelEchap pnlEchap;
	private PanelLobby pnlLobby;
	private PanelAccueil pnlAccueil;
	private PanelPartie pnlPartie;
	private JPanel lastPanel;
	private JPanel actualPanel;
	private JLabel lblImage;

	public Frame(Controleur c)
	{
		this.c = c;
		this.setTitle("Uno Dos Tres !");
		this.setLocation(0,0);
		this.setSize(1600,900);

		this.setLayout(new BorderLayout());
		this.lblImage = new JLabel(new ImageIcon(new ImageIcon("./img/uno_dos_tres.jpg").getImage().getScaledInstance(1600,900, Image.SCALE_DEFAULT)));
        this.setContentPane(this.lblImage);
        this.setLayout(new FlowLayout());

		this.pnlEchap = new PanelEchap(this.c);
		this.pnlAccueil = new PanelAccueil(this.c, this.ratio);
		this.pnlLobby = new PanelLobby(this.c);
		this.pnlPartie = new PanelPartie(this.c);
		this.actualPanel = new PanelBienvenue(c);
		this.lastPanel = null;

		this.add(this.actualPanel);

		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setVisible(true);
	}

	public void setRatio(float ratio)
	{
		this.ratio = ratio;
		this.lblImage.setIcon(new ImageIcon(new ImageIcon("./img/uno_dos_tres.jpg").getImage().getScaledInstance((int)(1600*this.ratio),(int)(900*this.ratio), Image.SCALE_DEFAULT)));
		this.pnlAccueil.setRatio(ratio);
		this.pnlLobby.setRatio(ratio);
		this.pnlEchap.setRatio(ratio);
	}

	public void resize()
	{
		this.setSize((int)(1599*this.ratio),(int)(899*this.ratio));
		this.setSize((int)(1600*this.ratio),(int)(900*this.ratio));
	}

	public void echap()
	{
		if (this.pnlEchap.estActif())
		{
			this.pnlEchap.plusActif();
			this.remove(this.actualPanel);
			this.actualPanel = this.lastPanel;
			this.lastPanel = this.pnlEchap;
			this.add(this.actualPanel);
		}
		else
		{
			this.pnlEchap.setActif();
			this.remove(this.actualPanel);
			this.lastPanel = this.actualPanel;
			this.actualPanel = this.pnlEchap;
			this.add(this.actualPanel);
		}
		this.resize();
	}

	public void accueil()
	{
		this.remove(this.actualPanel);
		this.lastPanel = this.actualPanel;
		this.actualPanel = this.pnlAccueil;
		this.add(this.actualPanel);
		this.resize();
	}

	public void lobby()
	{
		this.remove(this.actualPanel);
		this.c.getNewID();
		this.lastPanel = this.actualPanel;
		this.actualPanel = this.pnlLobby;
		this.add(this.actualPanel);
		this.resize();
	}

	public void reinitialiserParam()
	{
		this.pnlLobby.reinitialiserParam();
	}

	public void partie()
	{
		this.remove(this.actualPanel);
		this.lastPanel = this.actualPanel;
		this.actualPanel = this.pnlPartie;
		this.add(this.actualPanel);
		this.pnlPartie.mettreEnPlace();
		this.c.setPret(this.c.getPseudo());
		this.resize();
	}

	// Option echap
	protected JRootPane createRootPane()
	{
		ActionListener actionListenerForEscape= new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) { echap(); }
		};
		KeyStroke strokeEscape= KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
		JRootPane rootPane= new JRootPane();
		rootPane.registerKeyboardAction(actionListenerForEscape, strokeEscape, JComponent.WHEN_IN_FOCUSED_WINDOW);
		return rootPane;
	}
}