package units;

import plateau.Case;
import utils.Image;
import utils.Joueur;

abstract public class Unit {
    public Unit(Joueur joueur, Image image) {
        this.joueur = joueur;
        this.image = image;
    }

    void affiche(int x, int y) {
        image.affiche(x,y);
    }

    abstract public boolean peutEntrer(Case tile);
    // IMPORTANT !!! CASE EST UN MOT CLEF

    Joueur joueur;
    Image image;


}
