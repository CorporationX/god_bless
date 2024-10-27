package school.faang.mini.zoom;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {
    private static final int NUM_OF_PARTICIPANTS = 8;

    public static void main(String[] args) {
        Conference conference = new Conference(1, "Ретроспектива", NUM_OF_PARTICIPANTS);
        CompletableFuture.runAsync(conference::startStreaming);
        List<CompletableFuture<Void>> futures = IntStream.rangeClosed(1, NUM_OF_PARTICIPANTS)
                .mapToObj(i -> CompletableFuture.runAsync(() -> {
                    Participant participant = new Participant("user" + i);
                    participant.joinConference(conference);
                }))
                .toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .join();
    }
}
