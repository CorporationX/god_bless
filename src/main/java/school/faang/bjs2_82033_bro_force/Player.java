package school.faang.bjs2_82033_bro_force;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
@AllArgsConstructor
public class Player implements Runnable {
    private static final int MAX_ACTION_DELAY_MILLIS = 3000;
    private String name;
    private Game game;

    @Override
    public void run() {
        log.info("Player {} starting.", name);
        while (!game.isOver()) {
            waitUntilAction();
            log.info("Player {} doing action.", name);
            game.update();
        }
    }

    private void waitUntilAction() {
        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(MAX_ACTION_DELAY_MILLIS));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

    }
}
