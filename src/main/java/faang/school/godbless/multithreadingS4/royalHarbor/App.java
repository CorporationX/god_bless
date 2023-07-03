package faang.school.godbless.multithreadingS4.royalHarbor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Knight firstKnight = new Knight("Lancelot");
        Knight secondKnight = new Knight("Black Knight");

        fillTrials(firstKnight);
        fillTrials(secondKnight);

        executorService.submit(firstKnight::startTrials);
        executorService.submit(secondKnight::startTrials);

        executorService.shutdown();
    }

    private static void fillTrials(Knight knight) {
        String[] trialNames = {"trial by fire", "trial by water"};

        for (String trialName : trialNames) {
            knight.addTrial(new Trial(knight.getName(), trialName));
        }
    }
}
