package plateau;

public interface Contrainte {
    boolean initOk(Plateau plateau, int x, int y);
    boolean deplOk(Plateau plateau, int x, int y);
}
