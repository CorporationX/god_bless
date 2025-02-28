package school.faang;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Conference conference = new Conference(10);
        CompletableFuture.allOf(IntStream.range(0, 20)
                .mapToObj(i -> CompletableFuture.runAsync(() -> {
                    Participant participant = new Participant(conference);
                    participant.joinConference();
                }))
                .toArray(CompletableFuture[]::new)
        ).join();
    }
}
