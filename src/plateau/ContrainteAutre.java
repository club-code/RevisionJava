package plateau;

public class ContrainteAutre implements Contrainte {
    @Override
    public boolean initOk(Plateau plateau, int x, int y) {
        return plateau.grille[x][y].terrain != plateau.mer && plateau.grille[x][y].terrain != plateau.plaine;
    }

    @Override
    public boolean deplOk(Plateau plateau, int x, int y) {
        return 0 <= x && x< plateau.colonnes &&
                0<=y && y<plateau.lignes &&
                plateau.grille[x][y].terrain != plateau.mer;
    }
}
