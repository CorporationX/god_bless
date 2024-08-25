package faang.school.godbless.BJS2_23506;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight arthur = new Knight("Arthur");
        Knight lancelot = new Knight("Lancelot");
        arthur.addTrial(new Trial(arthur.getName(), "Sword Trial"));
        arthur.addTrial(new Trial(arthur.getName(), "Fire Trial"));
        lancelot.addTrial(new Trial(lancelot.getName(), "Water Trial"));
        lancelot.addTrial(new Trial(lancelot.getName(), "Mountain Trial"));
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        arthur.startTrials(executorService);
        lancelot.startTrials(executorService);
        executorService.shutdown();
    }
}
