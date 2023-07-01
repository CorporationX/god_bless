package faang.school.godbless.multithreading.tournament;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class King {
    public static void main(String[] args) {
        List<Knight> knights = IntStream.rangeClosed(1, 2)
                .mapToObj(i -> new Knight("Knight-" + i))
                .toList();

        knights.forEach(knight -> IntStream.rangeClosed(1, 2)
                .mapToObj(i -> new Trial(knight.getName(), "trial-" + i))
                .forEach(knight::addTrial));

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        knights.forEach(knight -> executorService.execute(knight::startTrials));
        executorService.shutdown();

        try {
            if (executorService.awaitTermination(2, TimeUnit.SECONDS)) {
                System.out.println("Турнир окончен");
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
