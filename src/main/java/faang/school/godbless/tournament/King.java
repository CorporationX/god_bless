package faang.school.godbless.tournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {

    public static void main(String[] args) {
        Knight knight1 = new Knight("John");
        Knight knight2 = new Knight("Mik");
        knight1.addTrial(new Trial(knight1.getName(), "Dragon Slaying"));
        knight1.addTrial(new Trial(knight1.getName(), "Rescuing the Princess"));
        knight2.addTrial(new Trial(knight2.getName(), "Defending the Castle"));
        knight2.addTrial(new Trial(knight2.getName(), "Jousting Tournament"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        knight1.startTrials(executorService);
        knight2.startTrials(executorService);

        executorService.shutdown();
    }
}
