package BJS2_62020;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        while (game.getLives() > 0) {
            boolean isScore = Math.random() < 0.5;
            boolean isLives = Math.random() >= 0.5;

            game.update(isScore, isLives);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                log.error("Thread interrupted", e);
            }
        }
    }
}
