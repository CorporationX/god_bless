package faang.school.godbless.bjs2_23503;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        var arthur = new Knight("Arthur");
        arthur.addTrial(new Trial(arthur.getName(), "Fight"));
        arthur.addTrial(new Trial(arthur.getName(), "Running"));

        var lancelot = new Knight("Lancelot");
        lancelot.addTrial(new Trial(lancelot.getName(), "Defence"));
        lancelot.addTrial(new Trial(lancelot.getName(), "Attack"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        arthur.startTrials(executorService);
        lancelot.startTrials(executorService);

        executorService.shutdown();
    }
}
