package school.faang.sprint3.bjs_49240;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class Main {
    public static void main(String[] args) {
        int gameLevels = 33;
        int sleepTime = 500;
        Random random = new Random();

        Game game = new Game();

        while (gameLevels > 0) {
            boolean getPoints = random.nextBoolean();
            boolean lostLife = random.nextBoolean();

            try {
                log.info("Game level: {}", gameLevels);
                game.update(getPoints, lostLife);
                gameLevels--;
                Thread.sleep(sleepTime);
            } catch (RuntimeException | InterruptedException e) {
                log.info("Game over");
                gameLevels = 0;
            }
        }
    }
}
