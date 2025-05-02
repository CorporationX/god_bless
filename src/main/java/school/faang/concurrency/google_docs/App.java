package school.faang.concurrency.google_docs;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class App {
    public static void main(String[] args) throws InterruptedException {
        CollaborativeDocument collaborativeDocument = new CollaborativeDocument();

        List<DocumentSection> sections = List.of(
                new DocumentSection("Section 1", collaborativeDocument),
                new DocumentSection("Section 2", collaborativeDocument),
                new DocumentSection("Section 3", collaborativeDocument),
                new DocumentSection("Section 4", collaborativeDocument),
                new DocumentSection("Section 5", collaborativeDocument),
                new DocumentSection("Section 6", collaborativeDocument));

        ExecutorService executor = Executors.newCachedThreadPool();

        sections.forEach((section) ->
                executor.execute(() -> {
                    Thread thread = new Thread(() -> {
                        section.write("New Data");
                        new DocumentSectionProcessor(section).run();
                    });
                    try {
                        thread.start();
                        thread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
        );

        executor.shutdown();
        if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
            System.err.println("Could not complete tasks in 1 minute. Forcing shutdown...");
            executor.shutdownNow(); // попытаться прервать оставшиеся
        } else {
            System.out.println("All tasks are completed");
        }

        log.info("Result of document process {}", collaborativeDocument);
    }
}
