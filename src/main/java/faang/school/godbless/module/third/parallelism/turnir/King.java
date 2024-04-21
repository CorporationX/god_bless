package faang.school.godbless.module.third.parallelism.turnir;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) {
        List<Knight> knights = List.of(new Knight("Сэр Ланцелот"), new Knight("Сэр Грут"));
        for (Knight knight : knights) {
            knight.addTrial(new Trial(knight.getName(), "Скакать на лошади 30км"));
            knight.addTrial(new Trial(knight.getName(), "Шутить смешные шутки при короле"));
            knight.addTrial(new Trial(knight.getName(), "Копать выгребную яму"));
        }
        ExecutorService executorService = Executors.newFixedThreadPool(knights.size());
        for (Knight knight : knights) {
            executorService.execute(knight::startTrials);
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
