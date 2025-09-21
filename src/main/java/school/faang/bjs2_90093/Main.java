package school.faang.bjs2_90093;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Game game = new Game(10);

        Runnable action = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                boolean earnedPoints = Math.random() < 0.5;
                boolean lostLife = Math.random() < 0.3;

                game.update(earnedPoints, lostLife);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    log.info("Меня прервали");
                    Thread.currentThread().interrupt();
                    break;
                }

                if (!game.isGameInProgress) {
                    break;
                }
            }
        };
        Thread thread1 = new Thread(action, "John");
        Thread thread2 = new Thread(action, "Drake");
        Thread thread3 = new Thread(action, "Patricia");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
