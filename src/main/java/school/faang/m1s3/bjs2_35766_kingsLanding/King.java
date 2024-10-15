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

        ExecutorService robert_service = Executors.newFixedThreadPool(1);
        ExecutorService arthur_service = Executors.newFixedThreadPool(1);

        robert.startTrials(robert_service);
        arthur.startTrials(arthur_service);

        robert_service.shutdown();
        arthur_service.shutdown();

        try {
            if (!(robert_service.awaitTermination(40, TimeUnit.SECONDS) &&
                    arthur_service.awaitTermination(40, TimeUnit.SECONDS))) {
                robert_service.shutdownNow();
                arthur_service.shutdownNow();
                System.out.println("The knights perished");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
