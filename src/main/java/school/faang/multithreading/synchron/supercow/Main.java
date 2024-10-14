package school.faang.multithreading.synchron.supercow;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private final static int THREAD_POOL_SIZE = 4;

    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss(3);

        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Player player3 = new Player("Player3");
        Player player4 = new Player("Player4");
        List<Player> players = Arrays.asList(player1, player2, player3, player4);

        ExecutorService service = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        players.forEach(player -> {
            service.submit(() -> {
                try {
                    player.startBattle(boss);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        });

        service.shutdown();
        if (!service.awaitTermination(60, TimeUnit.SECONDS)) {
            service.shutdownNow();
        }
    }
}
