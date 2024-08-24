package faang.school.godbless.tournamentInKingsLanding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) throws InterruptedException {
        Knight knight1 = new Knight("Jaime Lannister");
        Knight knight2 = new Knight("Jorah Mormont");

        knight1.addTrial(new Trial( "spear duel"));
        knight2.addTrial(new Trial( "spear duel"));

        knight1.addTrial(new Trial( "agility competition"));
        knight2.addTrial(new Trial( "agility competition"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(knight1.startTrails());
        executorService.submit(knight2.startTrails());
        executorService.shutdown();

        if (executorService.awaitTermination(1, TimeUnit.MINUTES)) {
            System.out.println("The tournament has finished.");
        }
    }
}
