package school.faang.godbless.bjs2_36861;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Game {
    private static final int MAX_PLAYERS = 3;
    private static final int NUMBER_OF_THREADS = 4;
    private static final int MIN_FIGHT_DURATION = 3000;
    private static final int MAX_FIGHT_DURATION = 10000;

    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss(MAX_PLAYERS);
        List<Player> playerList = List.of(
                new Player("Dashunya"),
                new Player("Kolyan"),
                new Player("Nyusha"),
                new Player("Senya"),
                new Player("Denchik"),
                new Player("Vovan"),
                new Player("Grisha"),
                new Player("Masha"),
                new Player("Goshan"),
                new Player("Sonechka")
        );
        ExecutorService pool = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        playerList.forEach(player -> pool.submit(() -> {
            boss.joinBattle(player);
            log.info("Player {} is fighting the boss...", player.getName());
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(MIN_FIGHT_DURATION, MAX_FIGHT_DURATION));
            } catch (InterruptedException e) {
                log.warn("Interrupted when fighting the boss");
                Thread.currentThread().interrupt();
            }
            boss.leaveBattle(player);
        }));
        pool.shutdown();
        if (pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS)) {
            log.info("All players have fought the boss");
        } else {
            throw new IllegalStateException("The pool was not terminated");
        }
    }
}
