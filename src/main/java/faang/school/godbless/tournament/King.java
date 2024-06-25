package faang.school.godbless.tournament;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight knightOne = new Knight("first");
        Knight knightTwo = new Knight("second");
        knightOne.addTrial(new Trial("First","capture world"));
        knightOne.addTrial(new Trial("First","capture world"));
        knightOne.addTrial(new Trial("First","capture world"));
        knightOne.addTrial(new Trial("First","capture world"));
        knightTwo.addTrial(new Trial("second","defen kingdom"));
        knightTwo.addTrial(new Trial("second","defen kingdom"));
        knightTwo.addTrial(new Trial("second","defen kingdom"));
        knightTwo.addTrial(new Trial("second","defen kingdom"));
        knightTwo.addTrial(new Trial("second","defen kingdom"));
        startTrials(List.of(knightOne,knightTwo));
    }
    public static void startTrials(List<Knight> knights) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        knights.forEach(knight -> {
            knight.getTrials().forEach(executorService::submit);
        });
        executorService.shutdown();
    }
}
