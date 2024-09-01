package faang.school.godbless.Zoom;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int THREAD_COUNT = 3;
    private static final int MIN_REQUIRED_PARTICIPANTS_TO_START_STREAMING = 5;

    public static void main(String[] args) {
        scheduleConference();
    }

    private static void scheduleConference() {
        try (ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT)) {
            Conference conference = new Conference("Daily Meeting", "Room 1", MIN_REQUIRED_PARTICIPANTS_TO_START_STREAMING);

            startStreaming(conference, executor);
            addRequiredParticipantsToConference(conference, executor);
            addExtraParticipantsToConference(conference, executor);

            shutdownExecutor(executor);
        } catch (Exception e) {
            handleError(e);
        }
    }

    private static void startStreaming(Conference conference, ExecutorService executor) {
        executor.submit(conference::startStreaming);
    }

    private static void addRequiredParticipantsToConference(Conference conference, ExecutorService executor) {
        addParticipantsToConference(conference, MIN_REQUIRED_PARTICIPANTS_TO_START_STREAMING, executor);
    }

    private static void addExtraParticipantsToConference(Conference conference, ExecutorService executor) {
        addParticipantsToConference(conference, 10, executor);
    }

    private static void addParticipantsToConference(Conference conference, int count, ExecutorService executor) {
        IntStream.range(0, count)
                .forEach(i -> executor.submit(() -> {
                    sleepForDelay(1_000L);
                    conference.addParticipant(new Participant("User " + i));
                }));
    }

    private static void sleepForDelay(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            handleError(e);
        }
    }

    private static void shutdownExecutor(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
            handleError(e);
        }
    }

    private static void handleError(Exception e) {
        log.error("An error occurred: {}", e.getMessage());
    }
}
