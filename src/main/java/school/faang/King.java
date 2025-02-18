package school.faang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    private static final int THREAD_POOL_SIZE = 2;

    public static void main(String[] args) {
        Knight knight1 = new Knight("Джейме Ланнистер");
        Knight knight2 = new Knight("Лорес Тирелл");
        knight1.addTrial(new Trial(knight1.getName(), "Сражение с драконом"));
        knight1.addTrial(new Trial(knight1.getName(), "Поединок с великаном"));
        knight2.addTrial(new Trial(knight2.getName(), "Испытание верности"));
        knight2.addTrial(new Trial(knight2.getName(), "Битва за честь"));

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        knight1.startTrials(executorService);
        knight2.startTrials(executorService);
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Trials haven't been completed in time.");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
