import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public static class Leaderboard {
    private final int capacity;
    ArrayList<Score> scoreboard;

    public Leaderboard(int c) {
        capacity = c;
        scoreboard = new ArrayList<>(capacity);
    }

    public void addScore(String n, int s) {
        scoreboard.add(new Score(n, s));
        update();
    }

    public int getHighScore() {
        int maxScore = 0;
        for (Score s : scoreboard) {
            maxScore = Math.max(s.getScore(), maxScore);
        }
        return maxScore;
    }

    public int getAverageScore() {
        int sum = 0;
        for (Score s : scoreboard) {
            sum += s.getScore();
        }
        return sum / scoreboard.size();
    }

    public boolean break1000() {
        for (Score s : scoreboard) {
            if (s.getScore() > 1000) {
                return true;
            }
        }
        return false;
    }

    public void printLeaderboard() {
        update();
        for (Score s : scoreboard) {
            System.out.println(s.getName() + ", " + s.getScore());
        }
    }

    private void update() {
        scoreboard.sort(Comparator.comparingInt(Score::getScore).reversed()); // Evil line of code to sort by score
        if (scoreboard.size() > capacity) {
            for (int i = 0; i < scoreboard.size() - capacity; i++) {
                scoreboard.removeLast();
            }
        }
    }
}

    public static void main(String[] args) {
        Leaderboard board = new Leaderboard(5);

        board.addScore("ABC", 100);
        board.addScore("DEF", 200);
        board.addScore("GHI", 250);
        board.addScore("JKL", 300);
        board.addScore("MNO", 205);

        System.out.println("High Score: " + board.getHighScore());
        System.out.println("Average Score: " + board.getAverageScore());
        System.out.println("Did a player break 1000 points?: " + board.break1000());

        System.out.println("\nLeaderboard: ");
        board.printLeaderboard();

        System.out.println("\nLeaderboard: ");
        board.addScore("PQR", 150);

        board.printLeaderboard();
    }