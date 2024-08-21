package faang.school.godbless.BJS223449;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight beks = new Knight("Beks");
        Knight aru = new Knight("Aru");

        beks.addTrial(new Trial(beks.getName(), "Trial of Strength"));
        beks.addTrial(new Trial(beks.getName(), "Trial of Agility"));

        aru.addTrial(new Trial(aru.getName(), "Trial of Wisdom"));
        aru.addTrial(new Trial(aru.getName(), "Trial of Courage"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        beks.startTrials(executorService);
        aru.startTrials(executorService);

        executorService.shutdown();
    }
}
