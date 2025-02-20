package school.faang.broforce;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        boolean earnedPoints = Math.random() > 0.5;
        boolean lostLife = Math.random() > 0.7;

        game.update(earnedPoints, lostLife);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}