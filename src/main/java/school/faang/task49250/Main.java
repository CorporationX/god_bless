package school.faang.task49250;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        while (game.getLives() > 0) {
            game.update(Math.random() < 0.5, Math.random() > 0.5);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Поток прерван {}", e.getMessage());
            }
        }
    }
}
