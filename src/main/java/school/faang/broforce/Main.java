package school.faang.broforce;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final int SLEEP_TIME = 100;

    public static void main(String[] args) {
        Game game = new Game();

        for (int i = 0; i < 15; i++) {
            boolean earnedPoints = Math.random() < 0.5;
            boolean lostLife = Math.random() < 0.9;

            game.update(earnedPoints, lostLife);

            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                log.error("Поток прерван");
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
