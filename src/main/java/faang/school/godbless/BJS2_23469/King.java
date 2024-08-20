package faang.school.godbless.BJS2_23469;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    private static final int THREAD_LIMIT = 2;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_LIMIT);

        Knight firstKnight = new Knight("Arthur");
        firstKnight.addTrial(new Trial(firstKnight.getName(), "archery"));
        firstKnight.addTrial(new Trial(firstKnight.getName(), "fencing"));
        firstKnight.startTrials(executor);

        Knight secondKnight = new Knight("Lancelot");
        secondKnight.addTrial(new Trial(secondKnight.getName(), "fencing"));
        secondKnight.addTrial(new Trial(firstKnight.getName(), "archery"));
        secondKnight.startTrials(executor);

        executor.shutdown();
    }
}
