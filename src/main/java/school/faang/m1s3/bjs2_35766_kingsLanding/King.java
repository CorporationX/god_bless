package school.faang.m1s3.bjs2_35766_kingsLanding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) {
        Knight robert = new Knight("Robert");
        Knight arthur = new Knight("Arthur");

        robert.addTrial(new Trial("Robert", "Swimming with sharks"));
        robert.addTrial(new Trial("Robert", "Riding through flames"));
        robert.addTrial(new Trial("Robert", "Running from dragon"));

        arthur.addTrial(new Trial("Arthur", "Running from dragon"));
        arthur.addTrial(new Trial("Arthur", "Swimming with sharks"));
        arthur.addTrial(new Trial("Arthur", "Riding through flames"));

        ExecutorService robertService = Executors.newFixedThreadPool(1);
        ExecutorService arthurService = Executors.newFixedThreadPool(1);

        robert.startTrials(robertService);
        arthur.startTrials(arthurService);

        robertService.shutdown();
        arthurService.shutdown();

        try {
            if (!(robertService.awaitTermination(40, TimeUnit.SECONDS) &&
                    arthurService.awaitTermination(40, TimeUnit.SECONDS))) {
                robertService.shutdownNow();
                arthurService.shutdownNow();
                System.out.println("The knights perished");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
