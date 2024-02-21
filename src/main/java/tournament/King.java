package tournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Knight sam = new Knight("Sam");
        Knight artem = new Knight("Artem");
        sam.addTrial(new Trial(sam.getName(), "trialBySam1"));
        sam.addTrial(new Trial(sam.getName(), "trialBySam2"));
        artem.addTrial(new Trial(artem.getName(), "trialByArtem1"));
        sam.addTrial(new Trial(artem.getName(), "trialByArtem2"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(sam);
        executorService.submit(artem);
        executorService.shutdown();

    }
}
