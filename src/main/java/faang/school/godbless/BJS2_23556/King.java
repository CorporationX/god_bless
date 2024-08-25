package faang.school.godbless.BJS2_23556;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {

    public static void main(String[] args) {

        Knight archer = new Knight("Legolas");
        Knight soldier = new Knight("Aragorn");

        archer.addTrial(new Trial(archer.getName(), "Dragon Slaying"));
        archer.addTrial(new Trial(archer.getName(), "Rescue the Princess"));
        soldier.addTrial(new Trial(soldier.getName(), "Find the Holy Grail"));
        soldier.addTrial(new Trial(soldier.getName(), "Defend the Castle"));

        ExecutorService executor = Executors.newFixedThreadPool(2);
        archer.startTrial(executor);
        soldier.startTrial(executor);
        executor.shutdown();
    }
}
