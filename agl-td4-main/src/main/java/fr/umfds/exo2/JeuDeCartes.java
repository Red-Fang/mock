package fr.umfds.exo2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Random;

public class JeuDeCartes {
    private ArrayList<Carte> cartes=new ArrayList<>();
    private Random rand=new Random(System.currentTimeMillis());

    public JeuDeCartes()  {
        for (Couleur c:Couleur.values()){
            for (int hauteur=1;hauteur<14;hauteur++){
                Carte carte= null;
                try {
                    carte = new Carte(hauteur, c);
                } catch (CarteIncorrecteException e) {
                    throw new RuntimeException(e);
                }
                cartes.add(carte);
            }
        }
    }

    public Carte pioche(){
        int i=rand.nextInt(nbCartes()); // entier entre 0 et le nb de cartes exclu
        Carte c=cartes.remove(i);
        return c;
    }

    public   ArrayList<ArrayDeque<Carte>> distribution(int nbCartes, int nbPaquets) throws Exception {
        ArrayList<ArrayDeque<Carte>> paquets=new ArrayList<>();
        if (nbCartes*nbPaquets>nbCartes()){
            throw new Exception("Pas assez de cartes");
        }
        for (int p=0;p<nbPaquets;p++){ // pour chaque paquet
            ArrayDeque<Carte> paquet=new ArrayDeque<Carte>();
            for (int c=0;c<nbCartes;c++){ // autant de fois que le nombre de cartes souhaité
                int i=rand.nextInt(nbCartes()); // on aurait aussi pu utiliser pioche
                paquet.addLast(cartes.remove(i));
            }
            paquets.add(paquet);
        }
        return paquets;
    }

    private int nbCartes(){
        return cartes.size();
    }



}
