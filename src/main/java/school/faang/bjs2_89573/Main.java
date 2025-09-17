package school.faang.bjs2_89573;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int TIME_WAITING_THREAD = 5;

    public static void main(String[] args) {

        Knight ilyaKnight = new Knight("Ilya");

        ilyaKnight.addTrial(new Trial("Ilya", "Archery"));
        ilyaKnight.addTrial(new Trial("Ilya", "Sword fighting"));
        ilyaKnight.addTrial(new Trial("Ilya", "Horse riding"));

        Knight vitalkaKnight = new Knight("Vitalka");

        vitalkaKnight.addTrial(new Trial("Vitalka", "Archery"));
        vitalkaKnight.addTrial(new Trial("Vitalka", "Sword fighting"));
        vitalkaKnight.addTrial(new Trial("Vitalka", "Horse riding"));

        Knight aldarKnight = new Knight("Aldar");

        aldarKnight.addTrial(new Trial("Aldar", "Archery"));
        aldarKnight.addTrial(new Trial("Aldar", "Sword fighting"));
        aldarKnight.addTrial(new Trial("Aldar", "Horse riding"));


        ExecutorService executor = Executors.newCachedThreadPool();

        ilyaKnight.startTrials(executor);
        vitalkaKnight.startTrials(executor);
        aldarKnight.startTrials(executor);


        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIME_WAITING_THREAD, TimeUnit.MINUTES)) {
                executor.shutdownNow();
                log.info("The waiting time for all thread has ended");
            }
        } catch (InterruptedException e) {
            executor.shutdown();
            log.error("Waiting was interrupted - Forced termination", e);
        }
    }
}
