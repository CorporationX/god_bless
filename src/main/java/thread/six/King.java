package thread.six;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Knight leo = new Knight("Leo");
        Knight roman = new Knight("Roman");

        leo.addTrial(new Trial("Leo", "Убить дракона"));
        leo.addTrial(new Trial("Leo", "Спасти принцессу"));
        roman.addTrial(new Trial("Roman", "Подготовить лошадь к турниру"));
        roman.addTrial(new Trial("Roman", "Победить в рыцарском турнире"));

        leo.startTrials(executorService);
        roman.startTrials(executorService);
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
