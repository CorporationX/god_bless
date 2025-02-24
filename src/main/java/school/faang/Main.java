package school.faang;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(0, 20);

        while (game.getLives() > 0) {
            boolean earnedPoints = Math.random() > 0.5;
            boolean lostLife = Math.random() > 0.7;

            game.update(earnedPoints, lostLife);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
