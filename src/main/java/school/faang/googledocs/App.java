package school.faang.googledocs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        CollaborativeDocument document = new CollaborativeDocument();

        DocumentSection section1 = new DocumentSection("Introduction", document);
        DocumentSection section2 = new DocumentSection("Conclusion", document);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(new DocumentSectionProcessor(section1, "hello, this is the introduction."));
        executor.submit(new DocumentSectionProcessor(section2, "this is the conclusion."));

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("Final content in Introduction: " + section1.read());
        System.out.println("Final content in Conclusion: " + section2.read());
    }
}

