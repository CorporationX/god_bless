package school.faang.bjs2_90111;

public class GameRunner {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        Thread[] players = new Thread[3];

        for (int i = 0; i < players.length; i++) {
            final int playerId = i + 1;
            players[i] = new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    boolean gainedPoint = Math.random() > 0.5;
                    boolean lostLife = Math.random() > 0.8;

                    game.update(gainedPoint, lostLife);

                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }, "Player-" + playerId);
        }

        for (Thread player : players) {
            player.start();
        }

        for (Thread player : players) {
            player.join();
        }

        System.out.printf("Игра завершена. Финальный счет: %d", game.getScore());
    }
}