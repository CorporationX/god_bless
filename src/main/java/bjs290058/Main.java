package bjs290058;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(4);

        Runnable playerAction = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                boolean gotPoint = Math.random() > 0.5;
                boolean lostLife = Math.random() > 0.7;

                game.update(gotPoint, lostLife);

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }

                if (!game.isGameInProgress()) {
                    break;
                }
            }
        };

        Thread p1 = new Thread(playerAction, "Player-1");
        Thread p2 = new Thread(playerAction, "Player-2");
        Thread p3 = new Thread(playerAction, "Player-3");

        p1.start();
        p2.start();
        p3.start();
    }
}
