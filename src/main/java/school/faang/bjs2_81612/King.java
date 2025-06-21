package school.faang.bjs2_81612;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) {
        Knight knightJaime = new Knight("Джейме Ланнистер");
        knightJaime.addTrial(new Trial(knightJaime.getName(), "Сражение с драконом"));
        knightJaime.addTrial(new Trial(knightJaime.getName(), "Поединок с великаном"));

        Knight knightLoras = new Knight("Лорес Тирелл");
        knightLoras.addTrial(new Trial(knightLoras.getName(), "Испытание верности"));
        knightLoras.addTrial(new Trial(knightLoras.getName(), "Битва за честь"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        knightJaime.startTrials(executorService);
        knightLoras.startTrials(executorService);

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
