package sources.gui.lobby;

import sources.Controleur;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelJoueurs extends JPanel implements ActionListener
{
	private Controleur c;
	private float ratio;
	private JButton btnAddBot;
	private PanelLogo[] pnlLogos;

	public PanelJoueurs(Controleur c)
	{
		this.c = c;
		this.ratio = 1;
		this.pnlLogos = new PanelLogo[4];

		this.setLayout(new GridLayout(5,1,(int)(0*ratio),(int)(50*ratio)));

		this.pnlLogos[0] = new PanelLogo(this.c);
		this.pnlLogos[1] = new PanelLogo(this.c);
		this.pnlLogos[2] = new PanelLogo(this.c);
		this.pnlLogos[3] = new PanelLogo(this.c);
		this.pnlLogos[0].setLogo(this.c.getPseudo());
		this.add(this.pnlLogos[0]);
		this.add(this.pnlLogos[1]);
		this.add(this.pnlLogos[2]);
		this.add(this.pnlLogos[3]);
		this.init(1);
		this.setOpaque(false);
	}

	public void setRatio(float ratio)
	{
		this.remove(this.btnAddBot);
		this.init(ratio);
		for (PanelLogo pl : this.pnlLogos)
			pl.setRatio(ratio);
	}

	private void init(float ratio)
	{
		this.btnAddBot = new JButton(new ImageIcon(new ImageIcon("./img/ajouter.png").getImage().getScaledInstance((int)(192*ratio),(int)(108*ratio), Image.SCALE_DEFAULT)));
		this.btnAddBot.setBorderPainted(false);
		this.btnAddBot.setContentAreaFilled(false);
		this.btnAddBot.addActionListener(this);
		this.add(this.btnAddBot);
	}

	public void reinitialiser()
	{
		for (int i = 1; i < this.pnlLogos.length; i++)
			pnlLogos[i].setLogo("personne");
	}

	public void actionPerformed(ActionEvent e)
	{
		if (this.c.addBot())
		{
			String[] tabP = this.c.getPseudos().split("¤");
			for (int i = 0; i < tabP.length; i++)
			{
				this.pnlLogos[i].setLogo(tabP[i]);
			}
			for (int i = 3; i > tabP.length; i--)
			{
				this.pnlLogos[i].setLogo("personne");
			}
		}

		this.c.resize();
	}
}