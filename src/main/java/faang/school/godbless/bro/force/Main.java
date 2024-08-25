package faang.school.godbless.bro.force;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Player neo = new Player("Neo", 3, true);
        Player triniti = new Player("Triniti", 3, true);
        Player morfious = new Player("Morfious", 3, true);
        Player keysMaster = new Player("Keys Master", 3, true);

        game.addPlayer(neo);
        game.addPlayer(triniti);
        game.addPlayer(morfious);
        game.addPlayer(keysMaster);

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < game.getPlayers().size(); i++) {
            executorService.submit(() -> {
                while (game.getPlayers().stream().noneMatch(player -> player.getLives() <= 0)) {
                    System.out.println("Is anyone dead? " + game.update());
                }
            });
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException exception) {
            log.error("Exception was occurred while shutdownNow executorService processing", exception);
            executorService.shutdownNow();
        }
    }
}
