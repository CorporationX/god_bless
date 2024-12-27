package school.faang.task_49410;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        for (int i = 0; i < 50; i++) {
            if (game.isGameOver()) {
                break;
            }

            boolean earnedPoints = Math.random() > 0.5;
            boolean lostLives = Math.random() > 0.5;

            game.update(lostLives, earnedPoints);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
