package school.faang.broforce;

public class Main {
    private static final int MILLIS = 100;

    public static void main(String[] args) {
        Game game = new Game();

        Runnable gameTask = () -> {
            for (int i = 0; i < 5; i++) {
                boolean scored = Math.random() > 0.5;
                boolean lostLife = Math.random() > 0.7;
                game.update(scored, lostLife);

                try {
                    Thread.sleep(MILLIS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread player1 = new Thread(gameTask, "Игрок 1");
        Thread player2 = new Thread(gameTask, "Игрок 2");
        Thread player3 = new Thread(gameTask, "Игрок 3");

        player1.start();
        player2.start();
        player3.start();
    }
}
