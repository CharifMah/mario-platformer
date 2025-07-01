package devforrest.mario.util.generators;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public abstract class BaseGenerator implements IProceduralGenerator {

    /**
     * Génère et sauvegarde une map à partir d'une grille de caractères.
     * Appelle cette méthode avec une grille générée dans la classe enfant.
     */
    public void generate(char[][] pGrid, String pMapSeed) {
        writeGridToFile(pGrid, "maps/map_output" + pMapSeed + ".txt");
    }

    /**
     * Écrit la grille de caractères dans un fichier texte.
     */
    protected void writeGridToFile(char[][] pGrid, String pFilePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pFilePath))) {
            for (char[] row : pGrid) {
                writer.write(row);
                writer.newLine();
            }
            System.out.println("La map a été écrite dans " + pFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    /**
     * Convertit une string en seed (long) pour Random.
     */
    public long seedFromString(String pSeedString) {
        // cm - Utilise le hashCode, casté en long pour éviter les collisions négatives
        return pSeedString != null ? pSeedString.hashCode() & 0xffffffffL : System.currentTimeMillis();
    }
}
