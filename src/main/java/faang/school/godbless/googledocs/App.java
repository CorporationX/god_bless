package faang.school.godbless.googledocs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class App {
    public static void main(String[] args) {
        CollaborativeDocument document = new CollaborativeDocument();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        DocumentSection section1 = new DocumentSection("section1", document);
        DocumentSection section2 = new DocumentSection("section2", document);
        DocumentSection section3 = new DocumentSection("section3", document);

        DocumentSectionProcessor processor1 = new DocumentSectionProcessor(section1, "Hello World!");
        DocumentSectionProcessor processor2 = new DocumentSectionProcessor(section2, "Concurrent Processing");
        DocumentSectionProcessor processor3 = new DocumentSectionProcessor(section3, "Java Multithreading");

        executorService.execute(processor1);
        executorService.execute(processor2);
        executorService.execute(processor3);

        shutdown(executorService);

        document.getAllSections().forEach((id, content) ->
                System.out.printf("Section %s + : %s%n", id, content));
    }

    private static void shutdown(ExecutorService executorService) {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
                if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                    log.error("Executor did not terminate");
                }
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}