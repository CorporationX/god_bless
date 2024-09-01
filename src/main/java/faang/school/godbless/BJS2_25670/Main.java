package faang.school.godbless.BJS2_25670;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int PARTICIPANT_COUNT = 20;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(PARTICIPANT_COUNT);
        Conference conference = new Conference("How to save the world lying on the couch");
        for (int i = 0; i < PARTICIPANT_COUNT; i++) {
            Participant participant = new Participant("Participant " + i);
            executorService.execute(() -> participant.joinConference(conference));
        }

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("All participants joined");
            } else {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
