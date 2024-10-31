package bjs2_37891;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Slf4j
public class Main {
    private static final int TOTAL_THREADS = 5;
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(TOTAL_THREADS);

    public static void main(String[] args) {
        int requiredParticipants = 2;
        Conference conference = new Conference(requiredParticipants);

        Participant firstParticipant = new Participant();
        Participant secondParticipant = new Participant();

        CompletableFuture<Void> startStream = CompletableFuture.runAsync(() -> {
            try {
                conference.startStreaming();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }, EXECUTOR_SERVICE);
        CompletableFuture<Void> firstParticipantJoin = CompletableFuture.runAsync(() -> {
            try {
                firstParticipant.joinConference(conference);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }, EXECUTOR_SERVICE);
        CompletableFuture<Void> secondParticipantJoin = CompletableFuture.runAsync(() -> {
            try {
                secondParticipant.joinConference(conference);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }, EXECUTOR_SERVICE);

        CompletableFuture.allOf(startStream, firstParticipantJoin, secondParticipantJoin).join();
    }
}
