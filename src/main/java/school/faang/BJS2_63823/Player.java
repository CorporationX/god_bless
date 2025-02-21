package school.faang.BJS2_63823;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
public class Player implements Runnable {
    private final String name;
    private final Game game;

    @Override
    public void run() {
        while (game.getLives() > 0) {
            gameAction();
        }
    }

    public void gameAction() {
        boolean isScore = ThreadLocalRandom.current().nextBoolean();
        game.update(isScore, name);
    }
}
