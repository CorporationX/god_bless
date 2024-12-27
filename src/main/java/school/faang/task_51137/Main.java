package school.faang.task_51137;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        CollaborativeDocument collaborativeDocument = new CollaborativeDocument();
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            DocumentSection documentSection = new DocumentSection(Integer.toString(i), collaborativeDocument);
            futures.add(CompletableFuture.runAsync(new DocumentSectionProcessor(documentSection)));
        }

        futures.forEach(CompletableFuture::join);
        collaborativeDocument.printAllData();
    }
}
