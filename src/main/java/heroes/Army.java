package heroes;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Logger;

@AllArgsConstructor
public class Army {
    private static final Logger logger = Logger.getLogger(Army.class.getName());
    private final List<Squad<? extends Warrior>> army;

    public int calculateTotalPower() throws InterruptedException {
        logger.info("Starting army power calculation...");
        List<Thread> threads = new ArrayList<>();
        List<Integer> results = new CopyOnWriteArrayList<>();

        for (var squad : army) {
            SquadThread squadThread = new SquadThread(squad, results);
            threads.add(squadThread);
            squadThread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                logger.severe("Thread " + thread.getName() + " was interrupted during join.");
                Thread.currentThread().interrupt();
                throw new InterruptedException("Army power calculation was interrupted.");
            }
        }

        int totalPower = results.stream().mapToInt(Integer::intValue).sum();
        logger.info("Total army power calculated: " + totalPower);
        return totalPower;
    }
}
