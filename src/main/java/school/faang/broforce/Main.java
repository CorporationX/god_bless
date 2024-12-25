package school.faang.broforce;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        while (!game.isTheEnd()) {
            boolean earnedPoints = Math.random() > 0.1;
            boolean lostLife = Math.random() > 0.7;

            game.update(earnedPoints, lostLife);
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
