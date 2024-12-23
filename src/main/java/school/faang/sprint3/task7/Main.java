package school.faang.sprint3.task7;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(0, 5);

        for (int i = 0; i < 100; i++) {
            boolean earnedPoints = Math.random() > 0.5;
            boolean lostLife = Math.random() > 0.7;

            if (!game.update(earnedPoints, lostLife)) {
                break;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.fillInStackTrace();
            }
        }
    }
}
