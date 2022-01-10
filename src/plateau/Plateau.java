package plateau;

public class Plateau {
    int lignes;
    int colonnes;
    Case[][] grille;

    public Plateau(int lignes, int colonnes) {
        this.lignes = lignes;
        this.colonnes = colonnes;

        grille = new Case[lignes][colonnes];

        for (Case[] ligne: grille) { // Exemple de for implicite
            for (int i = 0; i < colonnes; i ++) { // Exemple de for explicite
                ligne[i] = new Case();
            }
        }
    }

    void init() {
        for (Case[] ligne: grille) { // Exemple de for implicite
            for (int i = 0; i < colonnes; i ++) { // Exemple de for explicite
                ligne[i].terrain = mer;
            }
        }
    }

    void construitContinent(Terrain terrain, int n) throws ContientTropGrand{
        if ( n > colonnes * lignes) {
            throw new ContientTropGrand("Continent trop grand");
        }
        int x, y;
        while (true) {
            x = rand(lignes);
            y = rand(colonnes);
            if (grille[x][y].terrain == mer) break;
        }
        while (n!=0) {
            if (grille[x][y].terrain == mer) {
                grille[x][y].terrain = terrain;
                n--;
                // On pourrait checker n == 0 ici mais pas besoin, grâce au while
            }
            int direction = rand(4);
            if (direction == 0) x++;
            if (direction == 1) x--;
            if (direction == 2) y++;
            if (direction == 3) y--;
            x %= lignes;
            y %= colonnes;
            // On peut justifier ça en disant que la terre est ronde
            // Sinon on fait juste un while True
        }
    }

    void neoConstruitContinent(Terrain terrain, int n, ContrainteAutre contrainte) throws ContientTropGrand{
        if ( n > colonnes * lignes) {
            throw new ContientTropGrand("Continent trop grand");
        }
        int x, y;
        while (true) {
            x = rand(lignes);
            y = rand(colonnes);
            if (contrainte.initOk(this, x,y)) break;
        }
        while (n!=0) {
            if (grille[x][y].terrain == mer) {
                grille[x][y].terrain = terrain;
                n--;
                // On pourrait checker n == 0 ici mais pas besoin, grâce au while
            }
            int direction;
            while (true) {
                direction = rand(4);
                if (direction == 0 && contrainte.deplOk(this, x+1,y)) {
                    x++;
                    break;
                }
                if (direction == 1 && contrainte.deplOk(this, x-1,y)) {
                    x--;
                    break;
                }
                if (direction == 2 && contrainte.deplOk(this, x,y+1)) {
                    y++;
                    break;
                }
                if (direction == 3 && contrainte.deplOk(this, x,y-1)) {
                    y--;
                    break;
                }
            }
        }
    }


    // Pas dans le CF
    Terrain plaine;
    Terrain foret;
    Terrain colline;
    Terrain montagne;
    Terrain mer;

    private int rand(int max) {
        return 1;
    }
}
