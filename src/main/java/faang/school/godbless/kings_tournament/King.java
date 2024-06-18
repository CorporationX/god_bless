package faang.school.godbless.kings_tournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Artur");
        Knight knight2 = new Knight("Samuel");

        Trial[] firstKnightsTrials = new Trial[]{
                new Trial(knight1.getName(), knight1.getName() + "'s first trial"),
                new Trial(knight1.getName(), knight1.getName() + "'s second trial")
        };
        Trial[] secondKnightsTrials = new Trial[]{
                new Trial(knight2.getName(), knight2.getName() + "'s first trial"),
                new Trial(knight2.getName(), knight2.getName() + "'s second trial")
        };

        for (int i = 0; i < 2; i++) {
            knight1.addTrial(firstKnightsTrials[i]);
            knight2.addTrial(secondKnightsTrials[i]);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(knight1::startTrails);
        executorService.submit(knight2::startTrails);
        executorService.shutdown();
    }
}
