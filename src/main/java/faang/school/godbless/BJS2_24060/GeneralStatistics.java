package faang.school.godbless.BJS2_24060;


public class GeneralStatistics {
    private static int score;

    public static void addNewScore(int newScore) {
        score += newScore;
    }

    public static int getScore() {
        return score;
    }
}
