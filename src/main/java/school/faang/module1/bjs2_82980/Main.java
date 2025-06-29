package school.faang.module1.bjs2_82980;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int PARTICIPANT_COUNT = 5;
    private static final ExecutorService executor = Executors.newFixedThreadPool(PARTICIPANT_COUNT);
    private static final int TIMEOUT = 10;

    public static void main(String[] args) {

        Conference conference = new Conference(PARTICIPANT_COUNT);

        for (int i = 1; i <= PARTICIPANT_COUNT; i++) {
            executor.submit(new Participant("Участник №" + i, conference));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}