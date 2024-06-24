package faang.school.godbless.multithreading.tournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) throws InterruptedException {
        var lancelot = new Knight("Lancelot");
        var galahad = new Knight("Galahad");
        lancelot.addTrial(new Trial(lancelot.getName(), "Jousting Tournament"));
        lancelot.addTrial(new Trial(lancelot.getName(), "Swordsmanship Duel"));
        galahad.addTrial(new Trial(galahad.getName(), "Archery Competition"));
        galahad.addTrial(new Trial(galahad.getName(), "Melee Battle"));

        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        lancelot.startTrials(threadPool);
        galahad.startTrials(threadPool);

        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.MINUTES);
    }
}
