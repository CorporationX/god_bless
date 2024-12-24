package school.faang.sprint1.task_47639;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) throws InterruptedException {
        Knight firstKnight = new Knight("Harry");
        Knight twoKnight = new Knight("Rohn");
        firstKnight.addTrial(new Trial(firstKnight.getName(), "Jump over the fire"));
        twoKnight.addTrial(new Trial(twoKnight.getName(), "To swim over the river"));
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        firstKnight.startTrials(executorService);
        twoKnight.startTrials(executorService);
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("Project complete");
    }
}
