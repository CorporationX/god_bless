package faang.school.godbless.BJS2_25660;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        Conference conference = new Conference("Конференция по многопоточке", 5);

        List<Participant> participants = List.of(
                new Participant("Sasha"),
                new Participant("Petya"),
                new Participant("Masha"),
                new Participant("Misha"),
                new Participant("Olya")
        );

        ExecutorService executorService = Executors.newFixedThreadPool(conference.getBarrier().getParties());

        participants.forEach(participant -> executorService.submit(() -> {
            participant.joinConference();
            conference.waitForAllParticipants();
        }));

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("Конференция закончилась.");
    }
}
