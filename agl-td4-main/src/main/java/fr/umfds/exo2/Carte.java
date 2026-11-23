package fr.umfds.exo2;

public class Carte {
    private int hauteur;
    private Couleur couleur;

    public Carte(int hauteur, Couleur couleur) throws CarteIncorrecteException {
        if (hauteur>0&&hauteur<14) {
            this.hauteur = hauteur;
        }else{
            throw new CarteIncorrecteException();
        }
        this.couleur = couleur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public Couleur getCouleur() {
        return couleur;
    }
}
