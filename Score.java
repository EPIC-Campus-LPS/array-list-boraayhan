public class Score {
    final private String name;
    final private int score;

    public Score(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String toString() {
        return "Score{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}