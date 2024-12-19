package school.faang.bjs248062;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Knight knight1 = new Knight("King Parvin");
        Knight knight2 = new Knight("King Murad");

        knight1.addTrial(new Trial(knight1.getName(), "Conquest of Russia"));
        knight1.addTrial(new Trial(knight1.getName(), "Submission of Arab Caliphate"));
        knight2.addTrial(new Trial(knight2.getName(), "Troy"));
        knight2.addTrial(new Trial(knight2.getName(), "WWII"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        knight1.startTrials(executorService);
        knight2.startTrials(executorService);
        executorService.shutdown();
    }

}
