package school.faang.sprint_4.task_50962;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final int NUMBER_OF_USERS = 10;

    public static void main(String[] args) {
        Conference conference = new Conference(1, 10);
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        futures.add(CompletableFuture.runAsync(conference::startStreaming));


        for (int i = 1; i <= NUMBER_OF_USERS; i++) {
            int finalI = i;
            futures.add(CompletableFuture.runAsync(() -> new Participant(finalI).joinConference(conference)));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
    }
}
