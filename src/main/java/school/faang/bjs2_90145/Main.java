package school.faang.bjs2_90145;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final long TIMEOUT_MS = 100L;

    public static void main(String[] args) {
        Game game = new Game();

        log.info("Начало игры Bro Force!");
        for (int i = 0; i < 100; i++) {
            boolean earnedPoints = Math.random() < 0.5;
            boolean lostLife = Math.random() < 0.3;

            game.update(earnedPoints, lostLife);

            try {
                Thread.sleep(TIMEOUT_MS);
            } catch (InterruptedException e) {
                log.error("Игра прервана", e);
                Thread.currentThread().interrupt();
                break;
            }
        }

        log.info("Игра завершена!");
    }
}