package faang.school.godbless.BJS2_25545;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Zoom {
    public static void main(String[] args) {
        var conference = new Conference();
        var participant1 = new Participant("Alex");
        var participant2 = new Participant("Mike");
        var participant3 = new Participant("Anna");
        var participant4 = new Participant("Victoria");
        var executorService = Executors.newCachedThreadPool();

        Stream.of(participant1, participant2, participant3, participant4)
                .forEach(participant -> executorService
                        .submit(() -> participant.joinConference(conference))
                );

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.out.printf("%s was interrupted.%n", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }
}