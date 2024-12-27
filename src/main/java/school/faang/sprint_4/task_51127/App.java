package school.faang.sprint_4.task_51127;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class App {
    private static final int AMOUNT_OF_USERS = 10;

    public static void main(String[] args) {
        CollaborativeDocument collaborativeDocument = new CollaborativeDocument();

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 1; i <= AMOUNT_OF_USERS; i++) {
            int finalI = i;
            futures.add(CompletableFuture.runAsync(() -> {
                DocumentSection documentSection = new DocumentSection(String.valueOf(finalI), collaborativeDocument);
                documentSection.write("New data " + finalI);
                log.info("Data from section {}: {}", finalI, documentSection.read());
            }));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        System.out.println(collaborativeDocument.getSections());
    }
}
