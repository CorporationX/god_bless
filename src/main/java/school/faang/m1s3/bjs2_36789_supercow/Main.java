package school.faang.m1s3.bjs2_36789_supercow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Boss vader = new Boss(3);
        Player kenobi = new Player("Obi-Wan Kenobi");
        Player windu = new Player("Mace Windu");
        Player yoda = new Player("Yoda");
        Player luke = new Player("Luke Skywalker");
        Player solo = new Player("Han Solo");

        ExecutorService playerService = Executors.newCachedThreadPool();
        ScheduledExecutorService bossService = Executors.newSingleThreadScheduledExecutor();


        playerService.execute(() -> kenobi.startBattle(vader));
        playerService.execute(() -> windu.startBattle(vader));
        playerService.execute(() -> yoda.startBattle(vader));
        playerService.execute(() -> luke.startBattle(vader));
        playerService.execute(() -> solo.startBattle(vader));
        playerService.execute(() -> solo.quitBattle(vader));
        bossService.scheduleAtFixedRate(() -> vader.killPlayer(), 2, 2, TimeUnit.SECONDS);

        try {
            if (!(playerService.awaitTermination(10, TimeUnit.SECONDS)
                    && bossService.awaitTermination(3, TimeUnit.SECONDS))) {
                playerService.shutdownNow();
                bossService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread has been interrupted " + e.getMessage(), e);
        }
        System.out.println("The battle is over");
    }
}
