package school.faang.bjs2_73916;

import lombok.AllArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
public class GameRunner implements Runnable {
    private final Game game;

    @Override
    public void run() {
        while (game.isRunning()) {
            game.update(ThreadLocalRandom.current().nextBoolean(), ThreadLocalRandom.current().nextBoolean());
        }
    }
}
