package tournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Artur");
        Knight knight2 = new Knight("Jon Snow");

        knight1.addTrial(new Trial(knight1.getName(), "Swimming"));
        knight1.addTrial(new Trial(knight1.getName(), "Archery"));

        knight2.addTrial(new Trial(knight2.getName(), "Archery"));
        knight2.addTrial(new Trial(knight2.getName(), "Run"));

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(knight1::startTrial);
        executor.submit(knight2::startTrial);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
    }
}
