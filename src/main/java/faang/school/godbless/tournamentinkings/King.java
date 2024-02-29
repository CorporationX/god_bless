package faang.school.godbless.tournamentinkings;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    private static final List<String> trials = new ArrayList<>();
    private static final int NUMBER_OF_THREAD = 2;

    public static void main(String... args) throws InterruptedException {
        trials.add("sword fighting");
        trials.add("horse riding");
        List<Knight> knightList = List.of(new Knight("Artur"), new Knight("Richard"));
        startTrials(knightList);
    }

    public static void startTrials(List<Knight> knightList) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREAD);
        for (Knight knight : knightList) {
            for (String trial : trials) {
                Trial newtrial = new Trial(knight.getName(), trial);
                knight.addTrial(newtrial);
                executorService.submit(newtrial);
            }
        }
        executorService.shutdown();
        boolean done = executorService.awaitTermination(1, TimeUnit.MINUTES);
        if (done) {
            System.out.println("Все потоки успешно завершены");
        } else {
            System.out.println("Не все потоки были выполнены за выделенное время");
        }
    }
}
