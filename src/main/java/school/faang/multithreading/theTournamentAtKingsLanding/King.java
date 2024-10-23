package school.faang.multithreading.theTournamentAtKingsLanding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) throws InterruptedException {
        Knight knight1 = new Knight("Jorah");
        Knight knight2 = new Knight("Podrik");

        knight1.addTrial(new Trial(knight1.getName(), "trial1"));
        knight1.addTrial(new Trial(knight1.getName(), "trial2"));

        knight2.addTrial(new Trial(knight1.getName(), "trial3"));
        knight2.addTrial(new Trial(knight1.getName(), "trial4"));

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(knight1::startTrials);
        executor.execute(knight2::startTrials);

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }
}
