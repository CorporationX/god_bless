package tournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Paul");
        Knight knight2 = new Knight("James");

        Trial trial1 = new Trial(knight1.getName(), "Побороть дракона");
        Trial trial2 = new Trial(knight1.getName(), "Спасти принцессу");
        Trial trial3 = new Trial(knight1.getName(), "Run.");
        Trial trial4 = new Trial(knight2.getName(), "Побороть дракона");
        Trial trial5 = new Trial(knight2.getName(), "Спасти принцессу");
        Trial trial6 = new Trial(knight2.getName(), "Run.");

        knight1.addTrial(trial1);
        knight1.addTrial(trial2);
        knight1.addTrial(trial3);

        knight2.addTrial(trial4);
        knight2.addTrial(trial5);
        knight2.addTrial(trial6);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> knight1.startTrials());
        executorService.submit(() -> knight2.startTrials());

        executorService.shutdown();
    }
}
