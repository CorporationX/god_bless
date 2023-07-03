package faang.school.godbless.multithreading.king_landing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) throws InterruptedException {
        Knight richard = new Knight("Richard");
        Knight luke = new Knight("luke");
        richard.addTrial(new Trial("Richard", "duel"));
        richard.addTrial(new Trial("Richard", "archery"));
        luke.addTrial(new Trial("Luke", "Test of Courage"));
        luke.addTrial(new Trial("Luke", "Horse racing"));
        ExecutorService service = Executors.newFixedThreadPool(2);

        service.execute(richard::startTrials);
        service.execute(luke::startTrials);
        service.shutdown();
        service.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("Knights completed all trials");
    }
}
