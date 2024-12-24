package school.faang.sprint1.task_47639;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) throws InterruptedException {
        Knight firstKnight = new Knight("Harry");
        Knight secondKnight = new Knight("Rohn");
        firstKnight.addTrial(new Trial(firstKnight.getName(), "Jump over the fire"));
        secondKnight.addTrial(new Trial(secondKnight.getName(), "To swim over the river"));
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        firstKnight.startTrials(executorService);
        secondKnight.startTrials(executorService);
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Задача завершена");
            }
        } catch (InterruptedException e) {
            System.out.println("Задача прервана");
            executorService.shutdownNow();
        }
        System.out.println("Project complete");
    }
}
