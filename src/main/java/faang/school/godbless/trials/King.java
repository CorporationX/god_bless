package faang.school.godbless.trials;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        var knightA = new Knight("a");
        var knightB = new Knight("b");
        knightA.addTrial(new Trial("a", "slay dragon"));
        knightA.addTrial(new Trial("a", "kill hydra"));

        knightB.addTrial(new Trial("b", "find fairy"));
        knightB.addTrial(new Trial("b", "run a marathon"));

        ExecutorService executor = Executors.newFixedThreadPool(2);
        knightA.startTrials(executor);
        knightB.startTrials(executor);
        executor.shutdown();
    }
}
