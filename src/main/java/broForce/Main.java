package broForce;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        Player player1 = new Player("1");
        Player player2 = new Player("2");

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                player1.doBattle(game, true, false);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                player2.doBattle(game, false, true);
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            log.error("Main thread was interrupted while waiting.", e);
            Thread.currentThread().interrupt();
        }

        System.out.printf("Game is finished! Final score: %d\n", game.score);
    }
}
