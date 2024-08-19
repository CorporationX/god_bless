package faang.school.godbless.BJS2_23439;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) {
        Knight arthur = new Knight("Ланселот");
        Knight bob = new Knight("Персиваль");
        arthur.addTrial(new Trial(arthur.getName(), "Бой на мечах"));
        arthur.addTrial(new Trial(arthur.getName(), "Бой на копьях"));
        bob.addTrial(new Trial(bob.getName(), "Стрельба из лука"));
        bob.addTrial(new Trial(bob.getName(), "Верховая езда"));

        ExecutorService executor = Executors.newFixedThreadPool(2);
        arthur.startTrials(executor);
        bob.startTrials(executor);

        try {
            executor.shutdown();
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
