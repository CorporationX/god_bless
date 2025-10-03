package school.faang.bjs2_90222;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();

        for (int i = 0; i < game.getLives(); i++) {
            boolean earnedPoints = Math.random() < 0.5;
            boolean lostLife = Math.random() < 0.8;

            game.update(earnedPoints, lostLife);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
