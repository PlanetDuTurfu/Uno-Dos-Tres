package sources.gui.lobby;

import sources.Controleur;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelP1 extends JPanel implements ActionListener
{
	private Controleur c;
	private float ratio;
	private JButton piocheMultiple;
	private JButton stackers;
	private JButton partieRapide;
	private JButton equipes;
	private boolean bpm = false;
	private boolean bs = true;
	private boolean bpr = false;
	private boolean be = false;
	private PanelNbCartes pnlNbCartes;

	public PanelP1(Controleur c)
	{
		this.c = c;
		this.ratio = 1;
        this.setLayout(new GridLayout(2,3,15,15));
		this.pnlNbCartes = new PanelNbCartes(c);
		this.addBtns();
		this.setOpaque(false);
	}

	public void setRatio(float ratio)
	{
		this.ratio = ratio;
		this.removeBtn();
		this.setLayout(new GridLayout(2,3,(int)(15*this.ratio),(int)(15*this.ratio)));
		this.pnlNbCartes.setRatio(ratio);
		this.addBtns();
		this.c.resize();
	}

	public void reinitialiserParam()
	{
		this.removeBtn();
		this.bpm = false;
		this.bs = true;
		this.bpr = false;
		this.be = false;
		this.pnlNbCartes.reinitialiser();
		this.addBtns();
		this.c.resize();
	}

	private void removeBtn()
	{
		this.remove(this.piocheMultiple);
		this.remove(this.stackers);
		this.remove(this.partieRapide);
		this.remove(this.equipes);
		this.remove(this.pnlNbCartes);
	}

	private void addBtns()
	{
		if (this.bpm) this.piocheMultiple = new JButton(new ImageIcon(new ImageIcon("./img/ouiPM.png").getImage().getScaledInstance((int)(128*this.ratio),(int)(72*this.ratio), Image.SCALE_DEFAULT)));
		else this.piocheMultiple = new JButton(new ImageIcon(new ImageIcon("./img/nonPM.png").getImage().getScaledInstance((int)(128*this.ratio),(int)(72*this.ratio), Image.SCALE_DEFAULT)));
		if (this.bs) this.stackers = new JButton(new ImageIcon(new ImageIcon("./img/ouiStackers.png").getImage().getScaledInstance((int)(128*this.ratio),(int)(72*this.ratio), Image.SCALE_DEFAULT)));
		else this.stackers = new JButton(new ImageIcon(new ImageIcon("./img/nonStackers.png").getImage().getScaledInstance((int)(128*this.ratio),(int)(72*this.ratio), Image.SCALE_DEFAULT)));
		if (this.bpr) this.partieRapide = new JButton(new ImageIcon(new ImageIcon("./img/ouiPR.png").getImage().getScaledInstance((int)(128*this.ratio),(int)(72*this.ratio), Image.SCALE_DEFAULT)));
		else this.partieRapide = new JButton(new ImageIcon(new ImageIcon("./img/nonPR.png").getImage().getScaledInstance((int)(128*this.ratio),(int)(72*this.ratio), Image.SCALE_DEFAULT)));
		if (this.be) this.equipes = new JButton(new ImageIcon(new ImageIcon("./img/ouiEquipes.png").getImage().getScaledInstance((int)(128*this.ratio),(int)(72*this.ratio), Image.SCALE_DEFAULT)));
		else this.equipes = new JButton(new ImageIcon(new ImageIcon("./img/nonEquipes.png").getImage().getScaledInstance((int)(128*this.ratio),(int)(72*this.ratio), Image.SCALE_DEFAULT)));
		this.add(this.piocheMultiple);
		this.add(this.stackers);
		this.add(this.partieRapide);
		this.add(this.equipes);
		this.add(this.pnlNbCartes);
        this.piocheMultiple.setBorderPainted(false);
		this.stackers.setBorderPainted(false);
		this.partieRapide.setBorderPainted(false);
		this.equipes.setBorderPainted(false);
        this.piocheMultiple.setContentAreaFilled(false);
		this.stackers.setContentAreaFilled(false);
		this.partieRapide.setContentAreaFilled(false);
		this.equipes.setContentAreaFilled(false);
		this.piocheMultiple.addActionListener(this);
		this.stackers.addActionListener(this);
		this.partieRapide.addActionListener(this);
		this.equipes.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		this.removeBtn();
		if (e.getSource().equals(this.piocheMultiple))
		{
			this.bpm = !this.bpm;
			this.c.PM(this.bpm);
		}
		else if (e.getSource().equals(this.stackers))
		{
			this.bs = !this.bs;
			this.c.ST(this.bs);
		}
		else if (e.getSource().equals(this.partieRapide))
		{
			this.bpr = !this.bpr;
			this.c.PR(this.bpr);
		}
		else if (e.getSource().equals(this.equipes))
		{
			this.be = !this.be;
			this.c.EQ(this.be);
		}
		this.addBtns();
		this.c.resize();
	}
}