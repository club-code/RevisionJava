package units;

import plateau.Case;
import utils.Image;
import utils.Joueur;

public class Combatant extends Unit {
    public Combatant(Joueur joueur, Image image) {
        super(joueur, image);
    }

    @Override
    public boolean peutEntrer(Case tile) {
        for (Unit unit : tile.listUnits) {
            if (unit instanceof Combatant) {
                return false;
            }
        }
        return true;
    }
}
