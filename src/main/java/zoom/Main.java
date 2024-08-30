package zoom;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {
    private static final int MEMBER_COUNT = 10;

    public static void main(String[] args) {
        Conference conference = new Conference(MEMBER_COUNT);
        var futures = IntStream.range(0, 10)
                .mapToObj(i -> CompletableFuture.runAsync(
                        () -> new Participant("User_" + i).joinConference(conference)))
                .toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
    }
}
