package school.faang.task_49290;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    private static final int THREAD_COUNT = 2;
    private static final int DELAY = 2000;

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
            Random random = new Random();
            int playerIndex = random.nextInt(currentPlayers.length);
            Player player = currentPlayers[playerIndex];
            player.setAlive(random.nextBoolean());

            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                log.warn("Main thread was interrupted", e);
            }

            service.submit(() -> game.update(player));
        }

        service.shutdown();
    }
}
