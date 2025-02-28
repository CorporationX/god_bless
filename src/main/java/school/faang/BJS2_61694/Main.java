package school.faang.BJS2_61694;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static school.faang.BJS2_61694.ConstAndMessages.TOTAL_RESULT;
import static school.faang.BJS2_61694.ConstAndMessages.WINNER_OF_GAME;

@Slf4j
public class Main {
    private static final Game game = new Game();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            game.addPlayer(new Bro("Bro#" + i));
        }
        while (game.getPlayers().size() > 1) {
            executorService.submit(game::update);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        executorService.shutdown();
        log.info(WINNER_OF_GAME, game.getPlayers().get(0).getName());
        log.info(TOTAL_RESULT, game.getScore(), game.getLives());
    }
}
