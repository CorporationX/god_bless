package faang.school.godbless;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Sir Lancelot");
        knight1.addTrial(new Trial(knight1.getName(), "Jousting"));
        knight1.addTrial(new Trial(knight1.getName(), "Sword Fighting"));

        Knight knight2 = new Knight("Sir Galahad");
        knight2.addTrial(new Trial(knight2.getName(), "Archery"));
        knight2.addTrial(new Trial(knight2.getName(), "Horsemanship"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (Trial trial : knight1.getTrials()) {
            executorService.submit(trial);
        }
        for (Trial trial : knight2.getTrials()) {
            executorService.submit(trial);
        }
        executorService.shutdown();
    }
}
