package fr.umfds.exo2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class JeuBataille {
    JeuDeCartes jeu;
    private Deque<Carte> joueur1;
    private Deque<Carte> joueur2;


    public JeuBataille(JeuDeCartes jeu)  {
        this.jeu=jeu;
        try {
            ArrayList<ArrayDeque<Carte>> distri = jeu.distribution(26, 2);
            joueur1=distri.get(0);
            joueur2= distri.get(1);
        } catch (Exception e) {
            // tant pis, si on a mal compté, ça crashe
            throw new RuntimeException(e);
        }

    }

    public boolean jeuFini() {
        return joueur1.isEmpty() || joueur2.isEmpty();
    }

    public int numJoueurGagnant() {
        if (joueur1.isEmpty()) return 2;
        if (joueur2.isEmpty()) return 1;
        return -1;
    }

    public int tailleJeuJoueur1(){
        return joueur1.size();
    }


    public int tailleJeuJoueur2(){
        return joueur2.size();
    }
    public boolean round() {
        Carte j1 = joueur1.removeFirst();
        Carte j2 = joueur2.removeFirst();
        ArrayList<Carte> cartesjouees = new ArrayList<>();
        while (j1.getHauteur() == j2.getHauteur() && !jeuFini()) {
            cartesjouees.add(j1);
            cartesjouees.add(j2);
            j1 = joueur1.removeFirst();
            j2 = joueur2.removeFirst();
        }
        cartesjouees.add(j1);
        cartesjouees.add(j2);

            if (j1.getHauteur() > j2.getHauteur()) {
                joueur1.addAll(cartesjouees);
            } else {
                joueur2.addAll(cartesjouees);
            }
       return jeuFini();
    }

}
