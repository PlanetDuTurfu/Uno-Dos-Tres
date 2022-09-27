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
    private int sensHoraire;
    private int pileAddition;
    private boolean fini;

    // Paramètres de partie
    private boolean piocheMultiple = false;
    private boolean stackers = true;
    private boolean partieRapide;
    private boolean equipes;
    private int nbCartesDansLaPioche = 0;
    private int nbCartesParJoueur = 7;

    public Partie(String id, Joueur j)
    {
        this.id = id;
        this.cartes = new ArrayList<Carte>();
        this.joueurs = new ArrayList<Joueur>();
        this.joueurs.add(j);
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

    public int getCharBot()
    {
        return bot++;
    }

    public void reinitialiserParam()
    {
        this.piocheMultiple = false;
        this.stackers = true;
        this.partieRapide = false;
        this.equipes = false;
        this.nbCartesParJoueur = 7;
    }

    public void PM(boolean b)
    {
        this.piocheMultiple = b;
    }

    public void ST(boolean b)
    {
        this.stackers = b;
    }

    public void PR(boolean b)
    {
        this.partieRapide = b;
    }

    public void EQ(boolean b)
    {
        this.equipes = b;
    }

    public void nbCartesParJoueur(int n)
    {
        this.nbCartesParJoueur = n;
    }

// Après le début de la partie
    public void demarrer()
    {
        this.init();
        this.init();
        this.distribuer();
        this.premiereCarte();
        this.joueurActuel = this.joueurs.get((int)(Math.random()*this.joueurs.size()));
    }

    public String[] getCartes(String pseudo)
    {
        String[] s = new String[0];
        for (Joueur j : this.joueurs)
            if (j.getPseudo().equals(pseudo)) return j.getCartes();
        return s;
    }

    public char getCoulLastCarte()
    {
        return this.lastCarte.getCouleur();
    }

    public String getValLastCarte()
    {
        return this.lastCarte.getValeur();
    }

    public void setPret(String pseudo)
    {
        for (Joueur j : this.joueurs)
            if (j.getPseudo().equals(pseudo)) j.setPret();
        int nbJoueursPrets = 0;
        for (Joueur j : this.joueurs)
            if (j.estPret()) nbJoueursPrets++;
        if (nbJoueursPrets == this.joueurs.size())
        {
            System.out.println("Première carte : " + this.lastCarte + ".");
            for (Joueur j : this.joueurs)
            {
                j.trierCartes();
                System.out.println(j.toString());
            }
            System.out.println(this.joueurActuel.getPseudo() + " commence à jouer.");
            this.jouerBot();
        }
    }

    private void jouerBot()
    {
        if (this.joueurActuel.estRobot())
        {
            if (this.joueurActuel.peutJouer(this.lastCarte)) this.jouerCarte(this.joueurActuel.jouerAleatoire());
            else this.piocher(0);
            this.prochainTour();
        }
    }

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
        this.cartes.add(new Carte("si",'R'));
        this.cartes.add(new Carte("si",'J'));
        this.cartes.add(new Carte("si",'V'));
        this.cartes.add(new Carte("si",'B'));
        this.cartes.add(new Carte("si",'R'));
        this.cartes.add(new Carte("si",'J'));
        this.cartes.add(new Carte("si",'V'));
        this.cartes.add(new Carte("si",'B'));
        // Sens interdit
        this.cartes.add(new Carte("si",'R'));
        this.cartes.add(new Carte("si",'J'));
        this.cartes.add(new Carte("si",'V'));
        this.cartes.add(new Carte("si",'B'));
        this.cartes.add(new Carte("si",'R'));
        this.cartes.add(new Carte("si",'J'));
        this.cartes.add(new Carte("si",'V'));
        this.cartes.add(new Carte("si",'B'));
        // +2
        this.cartes.add(new Carte("p2",'R'));
        this.cartes.add(new Carte("p2",'J'));
        this.cartes.add(new Carte("p2",'V'));
        this.cartes.add(new Carte("p2",'B'));
        this.cartes.add(new Carte("p2",'R'));
        this.cartes.add(new Carte("p2",'J'));
        this.cartes.add(new Carte("p2",'V'));
        this.cartes.add(new Carte("p2",'B'));
        this.nbCartesDansLaPioche += 64;
        // Stacker
        if (this.stackers)
        {
            this.cartes.add(new Carte("st",'R'));
            this.cartes.add(new Carte("st",'J'));
            this.cartes.add(new Carte("st",'V'));
            this.cartes.add(new Carte("st",'B'));
            this.cartes.add(new Carte("st",'R'));
            this.cartes.add(new Carte("st",'J'));
            this.cartes.add(new Carte("st",'V'));
            this.cartes.add(new Carte("st",'B'));
            this.nbCartesDansLaPioche += 8;
        }
        // Changements de couleur
        this.cartes.add(new Carte("cc",'N'));
        this.cartes.add(new Carte("cc",'N'));
        // +4
        this.cartes.add(new Carte("p4",'N'));
        this.cartes.add(new Carte("p4",'N'));
        this.nbCartesDansLaPioche += 4;
    }

    private void distribuer()
    {
        for (int j = 0; j < this.joueurs.size(); j++)
            for (int i = 0; i < this.nbCartesParJoueur; i++)
                this.joueurs.get(j).addCarte(this.carteHasard());
    }

    private Carte carteHasard()
    {
        return this.cartes.get((int)(Math.random()*this.nbCartesDansLaPioche));
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
        
        this.verif();

        this.jouerBot();
    }

    private void verif()
    {
        // // S'il y a un +2, +4... de posé
        // if (this.pileAddition > 0)
        // {
        //     // Si le joueur ne peut pas jouer alors il pioche les cartes
        //     if (!this.joueurActuel.peutJouer(this.lastCarte))
        //     {
        //         int tmp = this.pileAddition;
        //         this.pileAddition = 0;
        //         this.lastCarte.plusActive();
        //         this.piocher(tmp);
        //     }
        //     else if (this.joueurActuel.estRobot())
        //         this.jouerCarte(this.joueurActuel.jouerAleatoire());
        //     else
        //     {
        //         int indice = Integer.parseInt(sc.nextLine());
        //         Carte c = this.joueurActuel.getCarte(indice);
        //         if (c == null) this.jouerCarte(this.carteHasard());
        //         else this.jouerCarte(c);
        //     }
        // }
        // else if (this.joueurActuel.peutJouer(this.lastCarte))
        // {
        //     if (this.joueurActuel.estRobot()) this.jouerCarte(this.joueurActuel.jouerAleatoire());
        //     else
        //     {
        //         int indice = Integer.parseInt(sc.nextLine());
        //         Carte c = this.joueurActuel.getCarte(indice);
        //         if (c == null) this.jouerCarte(this.carteHasard());
        //         else this.jouerCarte(c);
        //     }
        // }
        // else this.piocher(0);

        for (Joueur j : this.joueurs)
            System.out.println(j.toString());
        try { Thread.sleep(1000); } catch(Exception e) {}
    }

    private String toStringCartes()
    {
        String sRet = "";
        for (Carte c : this.cartes)
            sRet += c+" ";
        return sRet;
    }

// Actions
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
        // ArrayList<Joueur> vraiJoueurs = new ArrayList<Joueur>();
        // for (Joueur j : this.joueurs)
        //     if (!j.estRobot()) vraiJoueurs.add(j);

        if (nbCarte != 0)
        {
            System.out.println("Il pioche "+nbCarte+" cartes.\n\n\n");
            for (int i = 0; i < nbCarte; i++)
            {
                this.joueurActuel.addCarte(this.carteHasard());
                System.out.println("pioche " + this.joueurActuel.getCarte(this.joueurActuel.getCartes().length - 1));
                // this.serveur.send(this.joueurActuel.getCarte(this.joueurActuel.getNbCartes() - 1), vraiJoueurs.toArray());
            }
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
}