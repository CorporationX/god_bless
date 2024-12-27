package school.faang.broforce;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        while (!game.isTheEnd()) {
            boolean isEarnedPoints = Math.random() > 0.1;
            boolean isLostLife = Math.random() > 0.7;

            game.update(isEarnedPoints, isLostLife);
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
