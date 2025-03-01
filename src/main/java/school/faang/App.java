package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class App {
    private static final int TIMEOUT_SECONDS = 10;

    public static void main(String[] args) {
        CollaborativeDocument document = new CollaborativeDocument();
        List<DocumentSection> sections = Arrays.asList(
                new DocumentSection("section1", document),
                new DocumentSection("section2", document),
                new DocumentSection("section3", document)
        );
        List<String> texts = Arrays.asList("hello", "world", "java");

        for (int i = 0; i < sections.size(); i++) {
            sections.get(i).write(texts.get(i));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(sections.size());
        sections.forEach(section -> executorService.submit(new DocumentSectionProcessor(section)));

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                log.warn("Not all tasks have been completed on time.");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("awaitTermination was interrupted.");
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
        }
    }
}
