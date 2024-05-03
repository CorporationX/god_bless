package faang.school.godbless.sprint3.BJS2_6311;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    private static final int THREAD_COUNT = 3;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

        Knight robert = new Knight("Robert");
        robert.addTrial(new Trial(robert.getName(), "Combat Tournament"));
        robert.addTrial(new Trial(robert.getName(), "Endurance Competition"));

        Knight jaime = new Knight("Jaime");
        jaime.addTrial(new Trial(jaime.getName(), "Archery Tournament"));
        jaime.addTrial(new Trial(jaime.getName(), "Duel"));

        robert.startTrials(executorService);
        jaime.startTrials(executorService);

        executorService.shutdown();
    }
}