package faang.school.godbless.mini_zoom;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        Conference conference = new Conference(3);
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < conference.getTotalMembers(); i++) {
            String name = "Test" + i;
            futures.add(CompletableFuture.runAsync(() -> conference.addParticipant(new Participant(name)), executorService));
        }

        futures.forEach(CompletableFuture::join);
        executorService.shutdown();

        conference.endStreaming();
    }
}
