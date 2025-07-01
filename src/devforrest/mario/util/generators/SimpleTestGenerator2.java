package devforrest.mario.util.generators;

import java.util.Random;

public class SimpleTestGenerator2 extends BaseGenerator {

    public SimpleTestGenerator2(String pSeedString) {
        long lSeed = this.seedFromString(pSeedString);

        int width = 50;
        int height = 15;
        char[][] lGrid = new char[height][width];
        Random rand = new Random(lSeed);

        // cm - Génération du sol
        for (int x = 0; x < width; x++) {
            lGrid[height - 1][x] = EBloc.TILE_2.getSymbol();
        }

        // Vide ailleurs
        for (int y = 0; y < height - 1; y++) {
            for (int x = 0; x < width; x++) {
                lGrid[y][x] = EBloc.EMPTY.getSymbol();
            }
        }

        // Plateformes aléatoires à différentes hauteurs
        for (int i = 0; i < 3; i++) {
            int platY = height - 3 - rand.nextInt(height / 2);
            int platX = 2 + rand.nextInt(width - 12);
            int platLen = 5 + rand.nextInt(6);
            for (int x = platX; x < platX + platLen && x < width - 1; x++) {
                lGrid[platY][x] = EBloc.PLATFORM.getSymbol();
                // Parfois une pièce sur la plateforme
                if (rand.nextDouble() < 0.3) lGrid[platY - 1][x] = EBloc.COIN.getSymbol();
            }
        }

        // Quelques ennemis aléatoires sur le sol
        for (int i = 0; i < 5; i++) {
            int x = 2 + rand.nextInt(width - 4);
            char enemy = rand.nextBoolean() ? EBloc.GOOMBA.getSymbol() : EBloc.KOOPA.getSymbol();
            lGrid[height - 2][x] = enemy;
        }

        // Appelle generate pour sauvegarder la grille
        generate(lGrid,pSeedString);
    }
}
