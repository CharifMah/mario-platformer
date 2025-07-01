package devforrest.mario.util.generators;

public class SimpleTestGenerator extends BaseGenerator {

    public SimpleTestGenerator() {
        int width = 40;
        int height = 15;
        char[][] lGrid = new char[height][width];

        // Génération procédurale simple : sol en bas, vide ailleurs
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (y == height - 1) {
                    lGrid[y][x] = EBloc.TILE_2.getSymbol(); // sol
                } else {
                    lGrid[y][x] = EBloc.EMPTY.getSymbol();  // vide
                }
            }	
        }

        // Place le joueur "P" au sol, colonne 2 (par exemple)
        lGrid[height - 2][2] = EBloc.PLAYER.getSymbol();

        // Appelle generate pour sauvegarder la grille
        generate(lGrid,"");
    }
}
