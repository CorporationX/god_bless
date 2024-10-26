package broforce;

public class Main {
    private static final int NUMBER_OF_GAME_MOVES = 15;

    public static void main(String[] args) {
        Game game = new Game();

        Thread thread1 = new Thread(() -> startGame(game));
        Thread thread2 = new Thread(() -> startGame(game));
        Thread thread3 = new Thread(() -> startGame(game));

        thread1.start();
        thread2.start();
        thread3.start();
    }

    public static void startGame(Game game) {
        for (int i = 0; i < NUMBER_OF_GAME_MOVES; i++) {
            boolean earnedPoints = Math.random() > 0.5;
            boolean lifeLoss = Math.random() > 0.7;

            game.update(earnedPoints, lifeLoss);
        }
    }
}
