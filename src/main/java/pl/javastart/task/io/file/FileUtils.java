package pl.javastart.task.io.file;

import pl.javastart.task.model.PlayerStats;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static pl.javastart.task.error.ErrorUtils.*;

public class FileUtils {
    public static void savePlayerStatsToCsv(List<PlayerStats> playerStatsList, String filePath) {
        try (
                var writer = new BufferedWriter(new FileWriter(filePath))
        ) {
            for (PlayerStats playerStats : playerStatsList) {
                writer.write(playerStats.toCsv());
                writer.newLine();
            }
            System.out.printf("Dane zostały posortowane i zapisane do pliku " + filePath);
        } catch (IOException e) {
            printError("Nie udało się zapisać pliku " + filePath);
        }
    }
}