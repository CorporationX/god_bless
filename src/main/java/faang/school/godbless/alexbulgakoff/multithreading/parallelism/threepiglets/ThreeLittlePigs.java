package faang.school.godbless.alexbulgakoff.multithreading.parallelism.threepiglets;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Alexander Bulgakov
 */

public class ThreeLittlePigs {

    static final int COUNT_THREADS = 3;
    public static void main(String[] args) {
        Pig1Thread nifNif = new Pig1Thread("Ниф-Ниф", 1);
        Pig2Thread nufNuf = new Pig2Thread("Нуф-Нуф", 2);
        Pig3Thread nafNaf = new Pig3Thread("Наф-Наф", 3);

        List<PigThread> pigThreads = Arrays.asList(nifNif, nafNaf, nufNuf);

        ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREADS);

        for (PigThread pigThread : pigThreads) {
            executorService.submit(pigThread);
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println();
        System.out.println("Игра завершена!");
    }
}
