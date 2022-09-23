import sources.Controleur;

public class LancerJeu
{
    public static void main(String[] args) {
        try { new Controleur(args[0]); }
        catch(Exception e) { new Controleur("moi"); }
    }
}