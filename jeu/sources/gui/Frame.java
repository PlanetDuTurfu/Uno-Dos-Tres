package sources.gui;

import sources.Controleur;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private float ratio = 1;
	private PanelEchap pnlEchap;
	private Controleur c;
	private JLabel lblImage;

	public Frame(Controleur c)
	{
		this.c = c;
		this.setTitle("Uno Dos Tres !");
		this.setLocation(0,0);
		this.setSize(1600,900);

		this.setLayout(new BorderLayout());
		this.lblImage = new JLabel(new ImageIcon(new ImageIcon("./img/uno_dos_tres.jpg").getImage().getScaledInstance((int)(1600*this.ratio),(int)(900*this.ratio), Image.SCALE_DEFAULT)));
        this.setContentPane(this.lblImage);
        this.setLayout(new FlowLayout());

		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setVisible(true);
	}

	public void setRatio(float ratio)
	{
		this.ratio = ratio;
	}

	public void resize()
	{
		this.lblImage.setIcon(new ImageIcon(new ImageIcon("./img/uno_dos_tres.jpg").getImage().getScaledInstance((int)(1600*this.ratio),(int)(900*this.ratio), Image.SCALE_DEFAULT)));
		this.setSize((int)(1599*this.ratio),(int)(899*this.ratio));
		this.setSize((int)(1600*this.ratio),(int)(900*this.ratio));
	}

	public void echap()
	{
		if (this.pnlEchap != null)
		{
			this.backToGame();
		}
		else
		{
			System.out.println("ajout");
			this.pnlEchap = new PanelEchap(this.c);
			this.add(this.pnlEchap);
		}
		System.out.println("echap");
		this.resize();
	}

	public void backToGame()
	{
		this.remove(this.pnlEchap);
		this.pnlEchap = null;
	}

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