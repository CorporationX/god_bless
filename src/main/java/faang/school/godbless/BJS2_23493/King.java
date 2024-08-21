package faang.school.godbless.BJS2_23493;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Knight stark = new Knight("Eddard");
        Knight lannister = new Knight("Jaime");

        stark.addTrial(new Trial(stark.getName(), "Rescue Mission"));
        stark.addTrial(new Trial(stark.getName(), "The siege of the tower"));
        stark.addTrial(new Trial(stark.getName(), "Hunting"));

        lannister.addTrial(new Trial(lannister.getName(), "Rescue Mission"));
        lannister.addTrial(new Trial(lannister.getName(), "The siege of the tower"));
        lannister.addTrial(new Trial(lannister.getName(), "Hunting"));

        executor.execute(stark::startTrials);
        executor.execute(lannister::startTrials);
        executor.shutdown();
    }
}
