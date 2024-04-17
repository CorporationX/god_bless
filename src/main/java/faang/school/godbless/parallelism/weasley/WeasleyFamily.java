package faang.school.godbless.parallelism.weasley;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class WeasleyFamily {
    public static void main(String[] args) {
        int choresNumber = 200;
        Chore[] chores = new Chore[choresNumber];

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        log.info("Start of processing chores.");

        for (int i = 0; i < choresNumber; i++) {
            chores[i] = new Chore("Chore (" + i + ").");
            cachedThreadPool.submit(chores[i]);
        }

        cachedThreadPool.shutdown();

        log.info("All chores were given to  work.");
    }
}
