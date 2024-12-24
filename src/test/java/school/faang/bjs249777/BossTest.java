package school.faang.bjs249777;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class BossTest {
    private static final int SLEEP = 2000;
    private static final int MIN_GAME_TIME = 100;
    private static final int MAX_GAME_TIME = 1000;

    @Test
    public void battleTest() throws InterruptedException {
        List<Player> players = List.of(
                new Player("1"),
                new Player("2"),
                new Player("3"),
                new Player("4"),
                new Player("5")
        );

        Boss boss = new Boss(List.of(), 2);

        ExecutorService executorService = Executors.newFixedThreadPool(players.size());
        players.forEach(player -> executorService.submit(() -> {
            player.startBattle(boss);
            try {
                Thread.sleep(new Random().nextInt(MIN_GAME_TIME, MAX_GAME_TIME));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            player.finishBattle(boss);
        }));
        Thread.sleep(SLEEP);
        executorService.shutdown();

        Assertions.assertEquals(0, boss.getCurrentPlayers());
    }
}