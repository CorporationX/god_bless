package school.faang.bjs249349;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(0, 10);

        for (int i = 0; i < 100; i++) {
            boolean earnedPoints = Math.random() > 0.5;
            boolean lostLife = Math.random() > 0.7;

            game.update(earnedPoints, lostLife);
            if (game.getLives() <= 0) {
                break;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
