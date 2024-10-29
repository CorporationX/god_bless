package school.faangSprint4.t19;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    private static final int SECTIONS_COUNT = 3;
    private static final int SHUTDOWN_TIMEOUT = 5;

    public static void main(String[] args) {
        CollaborativeDocument document = new CollaborativeDocument();
        List<DocumentSection> sections = createSections(document);
        writeInitialContent(sections);
        processSections(sections);
        document.printAllSections();
    }

    private static List<DocumentSection> createSections(CollaborativeDocument document) {
        List<DocumentSection> sections = new ArrayList<>();
        for (int i = 1; i <= SECTIONS_COUNT; i++) {
            sections.add(new DocumentSection(String.valueOf(i), document));
        }
        return sections;
    }

    private static void writeInitialContent(List<DocumentSection> sections) {
        String[] initialContent = {
                "Hello from section one",
                "Greetings from section two",
                "Welcome to section three"
        };

        for (int i = 0; i < sections.size(); i++) {
            sections.get(i).write(initialContent[i]);
        }
    }

    private static void processSections(List<DocumentSection> sections) {
        ExecutorService executorService = Executors.newFixedThreadPool(sections.size());

        try {
            for (int i = 0; i < sections.size(); i++) {
                DocumentSectionProcessor processor = new DocumentSectionProcessor(sections.get(i));
                executorService.execute(processor);
            }
        } finally {
            shutdownAndAwaitTermination(executorService);
        }
    }

    private static void shutdownAndAwaitTermination(ExecutorService executorService) {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(SHUTDOWN_TIMEOUT, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
                if (!executorService.awaitTermination(SHUTDOWN_TIMEOUT, TimeUnit.SECONDS)) {
                    System.err.println("ExecutorService did not terminate");
                }
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            System.err.println("Shutdown interrupted: " + e.getMessage());
        }
    }
}