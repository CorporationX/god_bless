package school.faang.miniZoom;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int NUM_THREADS = Runtime.getRuntime().availableProcessors();
    private static final int REQUIRED_PARTICIPANTS = 5;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        Conference conference = new Conference(REQUIRED_PARTICIPANTS);
        for (int i = 0; i <= REQUIRED_PARTICIPANTS; i++) {
            executorService.submit(new Participant("Participant" + i, conference));
        }
        try {
            conference.getLatch().await();
            conference.startStreaming();
            executorService.shutdown();
        } catch (InterruptedException e) {
            throw new IllegalStateException("Conference has been interrupted", e);
        }

    }
}
