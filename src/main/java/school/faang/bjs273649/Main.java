package school.faang.bjs273649;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(10);

        Runnable playerAction = () -> {
            for (int i = 0; i < 100; i++) {
                if (!game.isGameRunning()) {
                    break;
                }

                boolean earnedPoints = Math.random() < 0.5;
                boolean lostLives = Math.random() < 0.3;

                game.update(earnedPoints, lostLives);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread player1 = new Thread(playerAction, "игрок 1");
        Thread player2 = new Thread(playerAction, "игрок 2");
        Thread player3 = new Thread(playerAction, "игрок 3");

        player1.start();
        player2.start();
        player3.start();
    }
}
