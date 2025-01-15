package school.faang.task_51234;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CollaborativeEditingApp {
    public static void main(String[] args) {
        CollaborativeDocument document = new CollaborativeDocument();

        DocumentSection section1 = new DocumentSection("Introduction", document);
        DocumentSection section2 = new DocumentSection("Body", document);
        DocumentSection section3 = new DocumentSection("Conclusion", document);

        DocumentSectionProcessor processor1 = new DocumentSectionProcessor(section1);
        DocumentSectionProcessor processor2 = new DocumentSectionProcessor(section2);
        DocumentSectionProcessor processor3 = new DocumentSectionProcessor(section3);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(processor1);
        executor.submit(processor2);
        executor.submit(processor3);

        executor.shutdown();
        try {
            while (!executor.isTerminated()) {
                executor.awaitTermination(1, TimeUnit.SECONDS);
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("Final document content:");
        System.out.println("Introduction: " + section1.read());
        System.out.println("Body: " + section2.read());
        System.out.println("Conclusion: " + section3.read());
    }
}