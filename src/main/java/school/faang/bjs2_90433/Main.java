package school.faang.bjs2_90433;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(4);

        Player player = new Player("Ben");
        Player player1 = new Player("Ben1");
        Player player2 = new Player("Ben2");
        Player player3 = new Player("Ben3");
        Player player4 = new Player("Ben4");
        Player player5 = new Player("Ben5");
        Player player6 = new Player("Ben6");
        Player player7 = new Player("Ben7");
        Player player8 = new Player("Ben8");
        Player player9 = new Player("Ben9");
        Player player10 = new Player("Ben10");

        ExecutorService ex = Executors.newFixedThreadPool(11);
        ex.execute(() -> player.doBattle(boss));
        ex.execute(() -> player1.doBattle(boss));
        ex.execute(() -> player2.doBattle(boss));
        ex.execute(() -> player3.doBattle(boss));
        ex.execute(() -> player4.doBattle(boss));
        ex.execute(() -> player5.doBattle(boss));
        ex.execute(() -> player6.doBattle(boss));
        ex.execute(() -> player7.doBattle(boss));
        ex.execute(() -> player8.doBattle(boss));
        ex.execute(() -> player9.doBattle(boss));
        ex.execute(() -> player10.doBattle(boss));

        try {
            ex.shutdown();
            if (!ex.awaitTermination(30, TimeUnit.SECONDS)) {
                ex.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.warn("{} has been interrupted. Too long waiting time", Thread.currentThread().getName());
            throw new RuntimeException(e);
        }
    }
}
