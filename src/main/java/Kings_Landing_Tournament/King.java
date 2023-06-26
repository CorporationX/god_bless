package Kings_Landing_Tournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Ser Barristan Selmy");
        Knight knight2 = new Knight("Ser Jaime Lannister");
        knight1.addTrial(new Trial(knight1.getName(), "hit the target with a bow"));
        knight1.addTrial(new Trial(knight1.getName(), "slay the enemy with a spear"));
        knight2.addTrial(new Trial(knight2.getName(), "win a sword battle"));
        knight2.addTrial(new Trial(knight2.getName(), "save a girl from a bear"));

        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (Trial trial : knight1.getTrials()) {
            executor.submit(trial);
        }
        for (Trial trial : knight2.getTrials()) {
            executor.submit(trial);
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.out.println("The knights did not have time to cope with the trials");
        }

        System.out.println("All the trials were carried out with honor by the knights of King's Landing");

    }
}
