package school.faang.multithreading.parallelism_thread.bjs2_89646;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final int TIME_DELAY = 1;

    public static void main(String[] args) {
        String[] chores = {
                "помыть посуду", "подмести пол", "приготовить ужин", "постирать белье",
                "сходить в магазин", "выхлопать половики", "покормить питомцев"
        };

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executorService.submit(new Chore(chore));
        }

        try {
            if (!executorService.awaitTermination(TIME_DELAY, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

    }
}
