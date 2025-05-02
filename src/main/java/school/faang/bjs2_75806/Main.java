package school.faang.bjs2_75806;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 60;
    private static final int MAX_EXPECTATION = 60;
    private static final int NUM_PARTICIPANTS = 20;
    private static final int NUM_CONFERENCES = 3;

    public static void main(String[] args) {
        ExecutorService poolThreads = Executors.newFixedThreadPool(NUM_THREADS);
        List<ParticipantService> participantServices = new ArrayList<>();
        List<Conference> conferences = new ArrayList<>();

        IntStream.range(1, NUM_PARTICIPANTS + 1)
                .forEach(i -> participantServices.add(
                        new ParticipantService(new Participant("participants " + i))));

        IntStream.range(1, NUM_CONFERENCES + 1)
                .forEach(i -> conferences.add(new Conference("conference " + i)));

        participantServices
                .forEach(service -> conferences
                        .forEach(conference -> poolThreads
                                .execute(() -> service.joinConference(conference))));

        shutdownPool(poolThreads);
    }

    private static void shutdownPool(ExecutorService pool) {
        pool.shutdown();
        try {
            boolean isClose = pool.awaitTermination(MAX_EXPECTATION, TimeUnit.SECONDS);
            if (!isClose) {
                pool.shutdownNow();
            }
        } catch (InterruptedException ex) {
            log.error("Thread stopped exception");
            pool.shutdownNow();
        }
    }
}
