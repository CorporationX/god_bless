package school.faang.tournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static final int THREADS_AMOUNT = 2;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_AMOUNT);

        Knight knight1 = new Knight("Джейме Ланнистер");
        Knight knight2 = new Knight("Лорес Тирелл");

        knight1.addTrial(new Trial(knight1.getName(), "Сражение с драконом"));
        knight1.addTrial(new Trial(knight1.getName(), "Поединок с великаном"));

        knight2.addTrial(new Trial(knight2.getName(), "Испытание верности"));
        knight2.addTrial(new Trial(knight2.getName(), "Битва за честь"));

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_AMOUNT);

        knight1.startTrials(executorService);
        knight2.startTrials(executorService);

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("Турнир завершён!");
    }
}
