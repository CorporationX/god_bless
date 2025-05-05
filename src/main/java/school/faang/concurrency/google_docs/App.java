package school.faang.concurrency.google_docs;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class App {
    public static void main(String[] args) throws InterruptedException {
        CollaborativeDocument collaborativeDocument = new CollaborativeDocument();
        List<DocumentSection> sections = new ArrayList<>();

        IntStream.range(0, 10).forEach((idx) ->
                sections.add(new DocumentSection("Section " + idx, collaborativeDocument)));

        ExecutorService executor = Executors.newCachedThreadPool();

        sections.forEach((section) ->
                executor.execute(() -> {
                    section.write("New Data");
                    new DocumentSectionProcessor(section).run();
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
