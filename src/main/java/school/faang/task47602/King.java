package school.faang.task47602;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    private static final int THREAD_POOL = 2;

    public static void main(String[] args) {

        Knight knight1 = new Knight("Джон Сноу");
        Knight knight2 = new Knight("Гора");

        knight1.addTrial(new Trial(knight1.getName(), "Сражение с ходаками"));
        knight1.addTrial(new Trial(knight1.getName(), "Поединок с великаном"));
        knight2.addTrial(new Trial(knight2.getName(), "Сражение с принцем"));
        knight2.addTrial(new Trial(knight2.getName(), "Поединок с братом"));

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL);

        knight1.startTrials(executorService);
        knight2.startTrials(executorService);

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
            System.out.println("Все рыцари выполнили свои испытания");
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
