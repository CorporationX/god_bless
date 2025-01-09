package school.faang.bjs251188;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {

        CollaborativeDocument collaborativeDocument = new CollaborativeDocument();
        collaborativeDocument.addData(0, "Design");
        collaborativeDocument.addData(1, "Marketing");

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        IntStream.range(0, 3)
                .mapToObj(i -> new DocumentSection(i, collaborativeDocument))
                .forEach(documentSection ->
                        futures.add(CompletableFuture.runAsync(new DocumentSectionProcessor(documentSection))));

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        collaborativeDocument.printAllData();
    }
}