package faang.school.godbless.zoom;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static int num_thread = 10;
    private static ExecutorService executor = Executors.newFixedThreadPool(num_thread);

    @SneakyThrows
    public static void main(String[] args) {
        List<Participant> participants = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            participants.add(new Participant(i, String.valueOf(i)));
        }
        Conference conference = new Conference(num_thread, "Conference");
        participants.forEach(part -> {
            CompletableFuture.runAsync(() -> part.joinConference(conference), executor);
        });
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        conference.startStreaming();
    }
}
