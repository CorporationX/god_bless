package school.faang.multithreading.concurr.google.docs;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    private static final int THREADS_COUNT = 3;
    private static final ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);

    public static void main(String[] args) {
        CollaborativeDocument collaborativeDocument = new CollaborativeDocument();

        DocumentSection documentSection1 = new DocumentSection("documentSection1", collaborativeDocument);
        DocumentSection documentSection2 = new DocumentSection("documentSection2", collaborativeDocument);
        DocumentSection documentSection3 = new DocumentSection("documentSection3", collaborativeDocument);

        documentSection1.write("dataForDocumentSection1");
        documentSection2.write("dataForDocumentSection2");
        documentSection3.write("dataForDocumentSection3");

        List<DocumentSection> documentSections = Arrays.asList(documentSection1, documentSection2, documentSection3);

        documentSections.forEach(documentSection -> executor.submit(new DocumentSectionProcessor(documentSection)));

        shutdown();
        awaitTermination();
    }

    private static void shutdown() {
        executor.shutdown();
    }

    private static void awaitTermination() {
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
