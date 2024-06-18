package faang.school.godbless.TournamentInKingsLanding;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;

public class King {
    public static void main(String[] args) {
        Knight knightOne = new Knight("Richard");
        Knight knightTwo = new Knight("Vincent");
        knightOne.addTrial(new Trial(knightOne.getName(), "jousting Tournament"));
        knightOne.addTrial(new Trial(knightOne.getName(), "sword Fighting Duel"));
        knightTwo.addTrial(new Trial(knightTwo.getName(), "sword Fighting Duel"));
        knightTwo.addTrial(new Trial(knightTwo.getName(), "jousting Tournament"));
        startTrials(List.of(knightOne, knightTwo));
    }

    public static void startTrials(List<Knight> knights) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        System.out.println("Tournament starts");
        knights.stream()
                .flatMap((knight) -> knight.getTrials().stream())
                .forEach(executorService::submit);
        try {
            executorService.awaitTermination(2, SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Tournament ends");
        executorService.shutdown();
    }
}
