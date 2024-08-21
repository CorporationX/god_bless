package faang.school.godbless.BJS2_24060;


public class GeneralStatistics {
    private static int score;
    private static int lostLives;

    public static void addNewScore(int newScore) {
        score += newScore;
    }

    public static void addNewLostLives(int newLostLives) {
        lostLives += newLostLives;
    }

    public static int getScore() {
        return score;
    }

    public static int getLostLives() {
        return lostLives;
    }
}
