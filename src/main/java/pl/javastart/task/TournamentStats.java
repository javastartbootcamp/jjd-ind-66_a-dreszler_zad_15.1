package pl.javastart.task;

import pl.javastart.task.io.DataReader;
import pl.javastart.task.io.file.FileUtils;
import pl.javastart.task.model.PlayerStats;

import java.util.*;

import static pl.javastart.task.constants.SortingConstants.*;
import static pl.javastart.task.error.ErrorUtils.*;

public class TournamentStats {
    private static final String SCORE_PLACEHOLDER = "";
    private static final String SCORE_FORMAT = "^\\p{L}+ \\p{L}+[ ]\\d+$";
    private static final String STOP = "STOP";
    private List<PlayerStats> playerStatList = new ArrayList<>();

    void run(Scanner scanner) {
        String fileName = "stats.csv";
        readScoresFromUser(scanner);
        sortStats(scanner);
        FileUtils.savePlayerStatsToCsv(playerStatList, fileName);
    }

    private void readScoresFromUser(Scanner scanner) {
        String score = SCORE_PLACEHOLDER;
        while (!score.equals(STOP)) {
            System.out.printf("Podaj wynik kolejnego gracza (lub %s aby zakończyć wczytywanie):\n", STOP);
            score = scanner.nextLine();
            if (score.matches(SCORE_FORMAT)) {
                String[] splitPlayerStats = score.split(" ");
                PlayerStats playerStats = new PlayerStats(splitPlayerStats[0], splitPlayerStats[1],
                        Integer.parseInt(splitPlayerStats[2]));
                playerStatList.add(playerStats);
            } else if (!score.equals(STOP)) {
                printError("Podano wynik w nieprawidłowym formacie. Prawidłowy format: Imię Nazwisko wynik");
            }
        }
    }

    private void sortStats(Scanner scanner) {
        int parameter = DataReader.readParameter(scanner);
        int order = DataReader.readSortingOrder(scanner);
        Comparator<PlayerStats> playerStatsComparator = getComparator(parameter, order);
        playerStatList.sort(playerStatsComparator);
    }

    private Comparator<PlayerStats> getComparator(int parameter, int order) {
        Comparator<PlayerStats> comparator = null;
        switch (parameter) {
            case FIRST_NAME -> comparator = new PlayerStats.FirstNameComparator();
            case LAST_NAME -> comparator = new PlayerStats.LastNameComparator();
            case SCORE -> comparator = new PlayerStats.ScoreComparator();
            default -> {
            }
        }

        if (order == DESCENDING_ORDER) {
            comparator = Collections.reverseOrder(comparator);
        }

        return comparator;
    }
}