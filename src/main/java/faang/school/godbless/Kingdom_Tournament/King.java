package faang.school.godbless.Kingdom_Tournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) {
        Knight arthur = new Knight("Arthur");
        Knight george = new Knight("George");
        arthur.addTrial(new Trial("Arthur", "Rally"));
        george.addTrial(new Trial("George", "Fighting"));
        ExecutorService execute = Executors.newFixedThreadPool(2);
        execute.submit(arthur::getTrials);
        execute.submit(george::getTrials);
        george.startTrials();
        arthur.startTrials();
        execute.shutdown();

    }
}