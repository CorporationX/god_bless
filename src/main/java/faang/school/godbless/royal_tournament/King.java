package faang.school.godbless.royal_tournament;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) {
        Knight knightOne = new Knight("Георгий");
        Knight knightTwo = new Knight("Стефан");
        Trial trialOne = new Trial(knightOne.getName(), "спасти принцессу");
        Trial trialTwo = new Trial(knightTwo.getName(), "убить дракона");
        knightOne.addTrial(trialOne);
        knightOne.addTrial(trialTwo);
        ExecutorService executors = Executors.newFixedThreadPool(2);
        knightOne.startTrials(executors);
        knightTwo.startTrials(executors);
        executors.shutdown();
    }
}
