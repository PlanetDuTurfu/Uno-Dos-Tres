package sources.worker;

import java.util.ArrayList;
import java.util.Collections;

public class Partie
{
    private static int bot = 0;
    private String id;
    private ArrayList<Carte> cartes;
    private ArrayList<Joueur> joueurs;
    private Carte lastCarte;
    private Joueur joueurActuel;
    private boolean piocheMultiple;
    private int sensHoraire;
    private int pileAddition;
    private boolean fini;

    public Partie(String id, Joueur j)
    {
        this.id = id;
        this.cartes = new ArrayList<Carte>();
        this.joueurs = new ArrayList<Joueur>();
        this.joueurs.add(j);
        this.piocheMultiple = false;
        this.fini = false;
        this.sensHoraire = 1;
        this.pileAddition = 0;
    }

// Avant le début de la partie
    public void addJoueur(Joueur j)
    {
        this.joueurs.add(j);
    }

    public String getID()
    {
        return this.id;
    }

    public int getNbJoueurs()
    {
        return this.joueurs.size();
    }

    public void exclure(String pseudo)
    {
        for (Joueur j : this.joueurs)
            if (j.getPseudo().equals(pseudo))
            {
                this.joueurs.remove(j);
                break;
            }
    }

    public String getPseudos()
    {
        String sRet = "";
        for (Joueur j : this.joueurs)
            sRet += j.getPseudo() + "¤";
        return sRet.substring(0,sRet.length()-1);
    }

    public char getCharBot()
    {
        return (char)((int)(bot)++);
    }

    public void demarrer()
    {
        this.init();
        this.distribuer();
        for (Joueur j : this.joueurs)
        {
            j.trierCartes();
            System.out.println(j.toString());
        }
        this.premiereCarte();
        this.joueurActuel = this.joueurs.get((int)(Math.random()*this.joueurs.size()));
        System.out.println(this.joueurActuel.getPseudo() + " commence à jouer.");
        System.out.println("Première carte : " + this.lastCarte + ".");

        while(!this.fini)
        {
            // S'il y a un +2, +4... de posé
            if (this.pileAddition > 0)
            {
                System.out.println("pileAddition > 0");
                // Si le joueur ne peut pas jouer alors il pioche les cartes
                if (!this.joueurActuel.peutJouer(this.lastCarte))
                {
                    System.out.println("ne peut pas jouer");
                    int tmp = this.pileAddition;
                    this.pileAddition = 0;
                    this.lastCarte.plusActive();
                    this.piocher(tmp);
                }
                else if (this.joueurActuel.estRobot())
                    this.jouerCarte(this.joueurActuel.jouerAleatoire());
            }
            else if (this.joueurActuel.estRobot())
            {
                System.out.println("pileAddition = 0");
                if (this.joueurActuel.peutJouer(this.lastCarte)) this.jouerCarte(this.joueurActuel.jouerAleatoire());
                else this.piocher(0);
            }

            for (Joueur j : this.joueurs)
                System.out.println(j.toString());
            try { Thread.sleep(500); } catch(Exception e) {}
            this.prochainTour();
        }
    }

// Après le début de la partie
    private void init()
    {
        // Numéros
        for (int i = 0; i < 10; i++)
        {
            this.cartes.add(new Carte(i+"",'R'));
            this.cartes.add(new Carte(i+"",'J'));
            this.cartes.add(new Carte(i+"",'V'));
            this.cartes.add(new Carte(i+"",'B'));
        }
        // Changement de sens
        this.cartes.add(new Carte("cs",'R'));
        this.cartes.add(new Carte("cs",'J'));
        this.cartes.add(new Carte("cs",'V'));
        this.cartes.add(new Carte("cs",'B'));
        // Sens interdit
        this.cartes.add(new Carte("si",'R'));
        this.cartes.add(new Carte("si",'J'));
        this.cartes.add(new Carte("si",'V'));
        this.cartes.add(new Carte("si",'B'));
        // +2
        this.cartes.add(new Carte("p2",'R'));
        this.cartes.add(new Carte("p2",'J'));
        this.cartes.add(new Carte("p2",'V'));
        this.cartes.add(new Carte("p2",'B'));
        // Stacker
        this.cartes.add(new Carte("st",'R'));
        this.cartes.add(new Carte("st",'J'));
        this.cartes.add(new Carte("st",'V'));
        this.cartes.add(new Carte("st",'B'));
        // Changements de couleur
        this.cartes.add(new Carte("cc",'N'));
        // +4
        this.cartes.add(new Carte("p4",'N'));
    }

    private void distribuer()
    {
        for (int j = 0; j < this.joueurs.size(); j++)
            for (int i = 0; i < 6; i++)
                this.joueurs.get(j).addCarte(this.carteHasard());
    }

    private Carte carteHasard()
    {
        return this.cartes.get((int)(Math.random()*58));
    }

    public void premiereCarte()
    {
        this.lastCarte = this.cartes.get((int)(Math.random()*40));
    }

    private void dernierCoup(Carte c)
    {
        System.out.println("Joue " + c);
        this.joueurActuel.retirerCarte(c);
        this.lastCarte = c;
        // Si +2
        if (c.getValeur().equals("p2")) this.pileAddition += 2;
        // Si +4
        if (c.getValeur().equals("p4")) this.pileAddition += 4;

        int tmp = this.joueurs.indexOf(this.joueurActuel) + this.sensHoraire;
        if (tmp < 0) tmp = this.joueurs.size() + tmp - 1;
        this.joueurActuel = this.joueurs.get((tmp) % 4);
        this.piocher(this.pileAddition);
        this.fini = true;
    }

    public void jouerCarte(Carte c)
    {
        System.out.println("Joue " + c + ".\n\n\n");
        this.joueurActuel.retirerCarte(c);
        this.lastCarte = c;
        this.actionCarte();
    }

    private void actionCarte()
    {
        String val = this.lastCarte.getValeur();
        // Si chiffre
        try {
            Integer.parseInt(val);
            return;
        } catch(Exception e) {}

        // Si sens interdit
        if (val.equals("si")) return;
        // Si +2
        if (val.equals("p2")) this.pileAddition += 2;
        // Si changement de sens
        if (val.equals("cs")) this.sensHoraire = this.sensHoraire * -1;
        // Si stacker
        if (val.equals("st")) this.joueurActuel.stacker(this.lastCarte.getCouleur());
        // Si +4
        if (val.equals("p4"))
        {
            this.pileAddition += 4;
            this.lastCarte = new Carte("p4",this.joueurActuel.choisirCouleur());
        }
        // Si changement de couleur
        if (val.equals("cc")) this.lastCarte = new Carte("cc",this.joueurActuel.choisirCouleur());
    }

    public void piocher(int nbCarte)
    {
        if (nbCarte != 0)
        {
            System.out.println("Il pioche "+nbCarte+" cartes.\n\n\n");
            for (int i = 0; i < nbCarte; i++)
                this.joueurActuel.addCarte(this.carteHasard());
        }
        else
        {
            if (this.piocheMultiple)
            {
                while (!this.joueurActuel.peutJouer(this.lastCarte))
                {
                    System.out.println("Il pioche une carte.");
                    this.joueurActuel.addCarte(this.carteHasard());
                }
                this.jouerCarte(this.joueurActuel.jouerAleatoire());
                System.out.println("\n\n\n");
            }
            else
            {
                System.out.println("Il pioche une carte.\n\n\n");
                this.joueurActuel.addCarte(this.carteHasard());
                if (this.joueurActuel.peutJouer(this.lastCarte))
                    this.jouerCarte(this.joueurActuel.jouerAleatoire());
            }
        }
    }

    private void prochainTour()
    {
        // Si un joueur n'a plus de cartes
        for (Joueur j : this.joueurs)
            if (j.hasWin())
            {
                this.fini = true;
                System.out.println(this.joueurActuel.getPseudo() + " remporte la partie.");
                return;
            }

        // S'il y a un sens interdit
        if (this.lastCarte.getValeur().equals("si"))
        {
            int tmp = this.joueurs.indexOf(this.joueurActuel) + 2 * this.sensHoraire;
            if (tmp < 0) tmp = this.joueurs.size() + tmp;
            this.joueurActuel = this.joueurs.get((tmp) % this.joueurs.size());
        }
        else
        {
            int tmp = this.joueurs.indexOf(this.joueurActuel) + this.sensHoraire;
            if (tmp < 0) tmp = this.joueurs.size() + tmp;
            this.joueurActuel = this.joueurs.get((tmp) % this.joueurs.size());
        }

        System.out.println("Au tour de " + this.joueurActuel.getPseudo() + " de jouer.");

        for (Joueur j : this.joueurs)
            j.nePeutPlusJouer();
    }

    private String toStringCartes()
    {
        String sRet = "";
        for (Carte c : this.cartes)
            sRet += c+" ";
        return sRet;
    }
}