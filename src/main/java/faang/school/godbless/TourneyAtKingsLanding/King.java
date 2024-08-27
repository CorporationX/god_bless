package faang.school.godbless.TourneyAtKingsLanding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Sir Lancelot");
        Knight knight2 = new Knight("Sir Gawain");

        knight1.addTrial(new Trial(knight1.getName(), "Trial of Might"));
        knight1.addTrial(new Trial(knight1.getName(), "Trial of Agility"));

        knight2.addTrial(new Trial(knight2.getName(), "Trial of Wisdom"));
        knight2.addTrial(new Trial(knight2.getName(), "Trial of Honor"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        knight1.startTrials(executorService);
        knight2.startTrials(executorService);

        executorService.shutdown();
    }
}