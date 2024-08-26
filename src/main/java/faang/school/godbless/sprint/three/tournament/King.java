package faang.school.godbless.sprint.three.tournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String... args) {

        Knight knight1 = new Knight("Vasia");
        Knight knight2 = new Knight("Petia");

        knight1.addTrial(new Trial(knight1.getName(), "Trial1"));
        knight1.addTrial(new Trial(knight1.getName(), "Trial2"));
        knight1.addTrial(new Trial(knight1.getName(), "Trial3"));

        knight2.addTrial(new Trial(knight2.getName(), "Trial4"));
        knight2.addTrial(new Trial(knight2.getName(), "Trial5"));
        knight2.addTrial(new Trial(knight2.getName(), "Trial7"));

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(knight1::startTrials);
        executor.submit(knight2::startTrials);

        executor.shutdown();

        try {
            if (!executor.awaitTermination(Constants.EXECUTOR_TIMEOUT, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            throw new RuntimeException(e);
        }

        System.out.println("Finish");

    }

}
