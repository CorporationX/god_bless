package faang.school.godbless.BJS223501;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight blackKnight = new Knight("Richard");
        Knight whiteKnight = new Knight("Greg");

        whiteKnight.addTrial(new Trial(whiteKnight.getName(), "get excalibur"));
        whiteKnight.addTrial(new Trial(whiteKnight.getName(), "kill the monster"));
        blackKnight.addTrial(new Trial(blackKnight.getName(), "overthrow the king"));
        blackKnight.addTrial(new Trial(blackKnight.getName(), "capture the castle"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        whiteKnight.startTrials(executorService);
        blackKnight.startTrials(executorService);

        executorService.shutdown();
    }
}
