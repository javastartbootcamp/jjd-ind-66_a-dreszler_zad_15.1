package pl.javastart.task.model;

import java.util.Comparator;

public class PlayerStats {
    private String firstName;
    private String lastName;
    private int score;

    public PlayerStats(String firstName, String lastName, int score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }

    public String toCsv() {
        return firstName + " " + lastName + ";" + score;
    }

    public static class FirstNameComparator implements Comparator<PlayerStats> {
        @Override
        public int compare(PlayerStats p1, PlayerStats p2) {
            return p1.firstName.compareTo(p2.firstName);
        }
    }

    public static class LastNameComparator implements Comparator<PlayerStats> {
        @Override
        public int compare(PlayerStats p1, PlayerStats p2) {
            return p1.lastName.compareTo(p2.lastName);
        }
    }

    public static class ScoreComparator implements Comparator<PlayerStats> {
        @Override
        public int compare(PlayerStats p1, PlayerStats p2) {
            return Integer.compare(p1.score, p2.score);
        }
    }
}
