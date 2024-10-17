package school.faang.tournament_in_kings_landing;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class King {
    private static final int THREAD_POOL_SIZE = 2;

    public static void main(String[] args) {
        Knight knightOfSwords = new Knight("Knight of Swords");
        Knight knightOfCups = new Knight("Knight of cups");

        knightOfSwords.addTrial(new Trial(knightOfSwords.getName(), "Trial of The Tempest Winds"));
        knightOfSwords.addTrial(new Trial(knightOfSwords.getName(), "Trial of the Blades of Conflict"));
        knightOfCups.addTrial(new Trial(knightOfCups.getName(), "Trial of Mirror Lake"));
        knightOfCups.addTrial(new Trial(knightOfCups.getName(), "Trial of the Heart's Labyrinth"));


        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        knightOfCups.startTrials(executor);
        knightOfSwords.startTrials(executor);

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            log.error("Exception in threads connected to awaitTermination method", e);
            e.printStackTrace();
            executor.shutdownNow();
        }
    }
}