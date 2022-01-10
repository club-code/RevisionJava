package plateau;

import units.Unit;

import java.util.ArrayList;
import java.util.Collection;

public class Case {
    public Terrain terrain;
    public final Collection<Unit> listUnits;
    public Ville ville;

    public Case() {
        terrain = null;
        listUnits = new ArrayList<Unit>();
        ville = null;
    }

    public void ajouteUnite(Unit unit) { listUnits.add(unit); }
}
