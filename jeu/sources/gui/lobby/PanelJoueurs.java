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
		this.pnlLogos[0].setLogo("moi");
		this.pnlLogos[0].removeBtn();
		this.btnAddBot = new JButton(new ImageIcon(new ImageIcon("./img/ajouter.png").getImage().getScaledInstance((int)(192*ratio),(int)(108*ratio), Image.SCALE_DEFAULT)));
		this.btnAddBot.setBorderPainted(false);
		this.btnAddBot.setContentAreaFilled(false);

		this.add(this.pnlLogos[0]);
		this.add(this.pnlLogos[1]);
		this.add(this.pnlLogos[2]);
		this.add(this.pnlLogos[3]);
		this.add(this.btnAddBot);
		this.btnAddBot.addActionListener(this);

		this.setOpaque(false);
	}

	public void setRatio(float ratio)
	{
		this.remove(this.btnAddBot);
		this.btnAddBot = new JButton(new ImageIcon(new ImageIcon("./img/ajouter.png").getImage().getScaledInstance((int)(192*ratio),(int)(108*ratio), Image.SCALE_DEFAULT)));
		this.btnAddBot.setBorderPainted(false);
		this.btnAddBot.setContentAreaFilled(false);
		this.btnAddBot.addActionListener(this);
		this.add(this.btnAddBot);
		for (PanelLogo pl : this.pnlLogos)
			pl.setRatio(ratio);
	}

	public void reinitialiser()
	{
		for (int i = 1; i < this.pnlLogos.length; i++)
		{
			pnlLogos[i].removeBtn();
			pnlLogos[i].setLogo("personne");
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		if (this.c.addBot(this.c.getID()))
		{
			String[] tabP = this.c.getPseudos(this.c.getID()).split("¤");
			for (int i = 0; i < tabP.length; i++)
			{
				this.pnlLogos[i].setLogo(tabP[i]);
				if (i == 0) this.pnlLogos[i].removeBtn();
			}
			for (int i = 3; i > tabP.length; i--)
			{
				this.pnlLogos[i].setLogo("personne");
				this.pnlLogos[i].removeBtn();
			}
		}

		this.c.resize();
	}
}