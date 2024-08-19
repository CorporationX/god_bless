package faang.school.godbless.tournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {

    private static final int THREAD_COUNT = 2;

    public static void main(String[] args) {
        Knight varya = new Knight("Varya");
        varya.addTrial(new Trial(varya.getName(), "trial1"));
        varya.addTrial(new Trial(varya.getName(), "trial2"));

        Knight knight = new Knight("Knight");
        knight.addTrial(new Trial(knight.getName(), "trial1"));
        knight.addTrial(new Trial(knight.getName(), "trial2"));

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        varya.startTrials(executor);
        knight.startTrials(executor);

        executor.shutdown();
    }
}
