package faang.school.godbless.minizoom;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int REQUIRED_PARTICIPANTS = 20;
    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        Conference conference = new Conference(REQUIRED_PARTICIPANTS);
        for (int i = 0; i < REQUIRED_PARTICIPANTS; i++) {
            int finalI = i;
            executorService.execute(() -> new Participant("Participant " + finalI).joinConference(conference));
        }
        shutdown();
    }

    private static void shutdown() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}