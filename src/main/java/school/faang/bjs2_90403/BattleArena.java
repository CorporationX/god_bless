package school.faang.bjs2_90403;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BattleArena {

    public static void main(String[] args) {
        Player player1 = new Player("Vasya");
        Player player2 = new Player("Lena");
        Player player3 = new Player("Vitya");
        Player player4 = new Player("Masha");

        Boss boss = new Boss("Hydra");

        ExecutorService exec = Executors.newFixedThreadPool(4);

        exec.submit(() -> player1.doBattle(boss));
        exec.submit(() -> player2.doBattle(boss));
        exec.submit(() -> player3.doBattle(boss));
        exec.submit(() -> player4.doBattle(boss));

        exec.shutdown();
        try {
            if (!exec.awaitTermination(10, TimeUnit.SECONDS)) {
                log.warn("This battle has been dragging on for way too long ...");
                exec.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Something has interrupted the battle");
            throw new RuntimeException(e);
        }
        log.info("Everyone has had their fun for today, let's go get some food now!");
        exec.shutdownNow();
    }
}
