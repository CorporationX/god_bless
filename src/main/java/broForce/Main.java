package broForce;

public class Main {
    private static final int NUMBER_OF_PLAYERS = 5;

    public static void main(String[] args) {
        Game game = new Game();

        for (int i = 0; i < NUMBER_OF_PLAYERS; i++) {
            Thread thread = new Thread(() -> {
                game.update();
                game.update();
                game.update();
                game.update();
                game.update();
                game.update();
            });
            thread.start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }




    }
}
