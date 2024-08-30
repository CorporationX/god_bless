package faang.school.godbless.zoom;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int MAX_PARTICIPANTS = 100;
    private static final long TIMEOUT = 20000L;

    public static void main(String[] args) throws InterruptedException {
        Conference conference = new Conference();

        ExecutorService executorService = Executors.newFixedThreadPool(MAX_PARTICIPANTS);
        for (int i = 0; i < MAX_PARTICIPANTS; i++) {
            Participant participant = new Participant("Guest " + i);
            executorService.execute(() -> participant.joinConference(conference));
        }
        executorService.shutdown();
        executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS);

        conference.printNumberParticipants();
    }
}
