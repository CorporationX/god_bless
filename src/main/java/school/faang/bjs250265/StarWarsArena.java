package school.faang.bjs250265;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Slf4j
public class StarWarsArena {
    private static final int AWAIT_TIME = 5;

    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);
        Robot bb8 = new Robot("BB-8", 6, 6);
        Robot bck = new Robot("BC-k", 9, 3);

        Robot winner1;
        Robot winner2;

        try {
            winner1 = battle.fight(r2d2, c3po).get();
            winner2 = battle.fight(bb8, bck).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        log.info("The winner is {}", winner1.name());
        log.info("The winner is {}", winner2.name());

        battle.executorService.shutdown();
        try {
            if (!battle.executorService.awaitTermination(AWAIT_TIME, TimeUnit.SECONDS)) {
                log.info("The tasks were not completed in 5 seconds, stoped the ThreadPool forcefully");
                battle.executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("The main thread {} was interrupted while waiting",
                    Thread.currentThread().getName());
        }
    }
}