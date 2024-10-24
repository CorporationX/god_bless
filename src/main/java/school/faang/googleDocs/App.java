package school.faang.googleDocs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    private static final int NUM_THREADS = 10;

    public static void main(String[] args) {
        CollaborativeDocument document = new CollaborativeDocument();
        document.addData("section0", "data0");
        document.addData("section1", "data1");

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < document.getSections().size(); i++) {
            DocumentSection section = new DocumentSection("section" + i, document);
            DocumentSectionProcessor processor = new DocumentSectionProcessor(section);
            executor.execute(processor);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new IllegalStateException("Failed to await termination");
        }
        document.printData();
    }
}
