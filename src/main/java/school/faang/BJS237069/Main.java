package school.faang.BJS237069;

public class Main {
    private static final int BEGINNING_SCORE = 10;
    private static final int BEGINNING_LIVES = 5;
    private static final double CHANCE_TO_EARN = 0.5;
    private static final double CHANCE_TO_LOST_LIVE = 0.6;
    private static final int WINNING_GAME_SCORE = 20;

    public static void main(String[] args) {
        Game game = new Game(BEGINNING_SCORE, BEGINNING_LIVES);

        while (game.getLives() != 0 || game.getScore() > WINNING_GAME_SCORE) {
            boolean earnedScore = Math.random() > CHANCE_TO_EARN;
            boolean lostLives = Math.random() > CHANCE_TO_LOST_LIVE;
            game.update(earnedScore, lostLives);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(" итоговый счет: " + game.getScore());
        if (game.getLives() > 0) {
            System.out.println(" Осталось " + game.getLives() + " жизней.");
        }
    }
}
