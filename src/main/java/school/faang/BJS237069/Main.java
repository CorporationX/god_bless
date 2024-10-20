package school.faang.BJS237069;

public class Main {
    private final static int SCORE = 10;
    private final static int LIVES = 5;

    public static void main(String[] args) {
        Game game = new Game(SCORE, LIVES);

        while (game.getLives() != 0 || game.getScore() > 20) {
            boolean earnedScore = Math.random() > 0.5;
            boolean lostLives = Math.random() > 0.6;
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
