package kings_landing_tournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) throws InterruptedException {
        Knight firstKnight = new Knight("First Knight");
        Knight secondKnight = new Knight("Second Knight");

        firstKnight.addTrial(new Trial(firstKnight.getName(), "first trial"));
        firstKnight.addTrial(new Trial(firstKnight.getName(), "second trial"));
        firstKnight.addTrial(new Trial(firstKnight.getName(), "third trial"));

        secondKnight.addTrial(new Trial(secondKnight.getName(), "first trial"));
        secondKnight.addTrial(new Trial(secondKnight.getName(), "second trial"));
        secondKnight.addTrial(new Trial(secondKnight.getName(), "third trial"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        firstKnight.startTrials(executorService);
        secondKnight.startTrials(executorService);

        executorService.shutdown();

        if (executorService.awaitTermination(5000L, TimeUnit.SECONDS)) {
            System.out.println("Все испытания прошли успешно");
        } else {
            System.out.println("Время на выполнение испытаний вышло");
        }
    }
}
