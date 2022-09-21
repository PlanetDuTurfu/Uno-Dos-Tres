package sources.worker;

import java.util.ArrayList;
import java.util.Collections;

public class Worker
{
    private ArrayList<Carte> cartes;
    private ArrayList<Joueur> joueurs;
    private Carte lastCarte;
    private Joueur joueurActuel;
    private boolean piocheMultiple;

    public Worker(String[] pseudos)
    {
        this.cartes = new ArrayList<Carte>();
        this.joueurs = new ArrayList<Joueur>();
        this.piocheMultiple = false;
        for (String s : pseudos)
            this.joueurs.add(new Joueur(s));
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
        this.joueurActuel = this.joueurs.get((int)(Math.random()*4));
        System.out.println(this.joueurActuel.getPseudo() + " commence à jouer.");
        System.out.println("Première carte : " + this.lastCarte + ".");
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
            for (int i = 0; i < 9; i++)
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

    public void jouerCarte(Carte c)
    {
        this.joueurActuel.retirerCarte(c);
        this.lastCarte = c;
        this.prochainTour();
    }

    public void piocher()
    {
        if (this.piocheMultiple)
        {

        }
        else
        {
            this.joueurActuel.addCarte(this.carteHasard());
        }

        this.prochainTour();
    }

    private void prochainTour()
    {
        this.joueurActuel = this.joueurs.get((this.joueurs.indexOf(this.joueurActuel) + 1) % 4);
        System.out.println("Au tour de " + this.joueurActuel.getPseudo() + " joueur.");
    }

    private String toStringCartes()
    {
        String sRet = "";
        for (Carte c : this.cartes)
            sRet += c+" ";
        return sRet;
    }
}