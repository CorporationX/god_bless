package school.faang.task_49290;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_COUNT = 2;
    private static final int DELAY = 2000;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Player john = new Player("john", 1);
        Player mike = new Player("mike", 2);
        Player dave = new Player("dave", 3);

        Game game = new Game();

        game.addPlayer(john);
        game.addPlayer(mike);
        game.addPlayer(dave);

        ExecutorService service = Executors.newFixedThreadPool(THREAD_COUNT);

        while (game.getPlayers().size() > 1) {
            Player[] currentPlayers = game.getPlayers().toArray(new Player[0]);
            int playerIndex = RANDOM.nextInt(currentPlayers.length);
            Player player = currentPlayers[playerIndex];
            player.setAlive(RANDOM.nextBoolean());

            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                log.warn("Main thread was interrupted", e);
                break;
            }

            service.submit(() -> game.update(player));
        }

        service.shutdown();
        try {
            if (!service.awaitTermination(DELAY, TimeUnit.MILLISECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }
}
