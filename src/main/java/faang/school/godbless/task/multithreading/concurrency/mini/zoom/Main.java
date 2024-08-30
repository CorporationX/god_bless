package faang.school.godbless.task.multithreading.concurrency.mini.zoom;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int CONFERENCE_ID = 1;
    private static final int NUMBER_OF_PARTICIPANT = 8;

    private static final Configuration config = new Configuration();
    private static final Conference conference = new Conference(CONFERENCE_ID, NUMBER_OF_PARTICIPANT);
    private static final ExecutorService executor = Executors.newFixedThreadPool(config.getNumberOfParticipant());

    public static void main(String[] args) {
        CompletableFuture.allOf(runTask().toArray(new CompletableFuture[0]))
                .join();
        executor.shutdown();
    }

    private static List<CompletableFuture<Void>> runTask() {
        return config.getParticipants()
                .stream()
                .map(participant -> CompletableFuture.runAsync(() -> participant.joinConference(conference), executor))
                .toList();
    }
}
