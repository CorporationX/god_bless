package school.faang.task51147;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        CollaborativeDocument document = new CollaborativeDocument();

        CompletableFuture.allOf(IntStream.range(0, 10)
                .peek(i -> document.addData(String.valueOf(i), String.format("data%s", i)))
                .mapToObj(i -> CompletableFuture.runAsync(new DocumentSectionProcessor(
                        new DocumentSection(String.valueOf(i), document))))
                .toArray(CompletableFuture[]::new)).join();
    }
}
