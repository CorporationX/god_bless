package school.faang.bjs2_90179;

public class Main {

    public static final int CURSED_NUMBER = 666;

    public static void main(String[] args) {
        Game game = new Game();

        for (int i = 0; i < CURSED_NUMBER; i++) {
            boolean earnPoints = Math.random() < 0.5;
            boolean lostLive = Math.random() < 0.5;
            game.update(lostLive, earnPoints);

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
