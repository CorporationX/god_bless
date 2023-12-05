package faang.school.godbless.GoogleDocs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws InterruptedException {
        CollaborativeDocument document = new CollaborativeDocument();
        DocumentSection section1 = new DocumentSection("Section1", document);
        DocumentSection section2 = new DocumentSection("Section2", document);
        DocumentSection section3 = new DocumentSection("Section3", document);
        DocumentSection section4 = new DocumentSection("Section4", document);
        DocumentSection section5 = new DocumentSection("Section5", document);
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.execute(() -> section1.writeContent("Section1 content"));
        executorService.execute(() -> section2.writeContent("Section2 content"));
        executorService.execute(() -> section3.writeContent("Section3 content"));
        executorService.execute(() -> section4.writeContent("Section4 content"));
        executorService.execute(() -> section5.writeContent("Section5 content"));

        executorService.execute(() -> new DocumentSectionProcessor(section1).run());
        executorService.execute(() -> new DocumentSectionProcessor(section2).run());
        executorService.execute(() -> new DocumentSectionProcessor(section3).run());
        executorService.execute(() -> new DocumentSectionProcessor(section4).run());
        executorService.execute(() -> new DocumentSectionProcessor(section5).run());

        executorService.shutdown();

        if (executorService.awaitTermination(5000, TimeUnit.MILLISECONDS)) {
            document.getDocument().forEach((key, value) -> {
                System.out.println(key + ": " + value);
            });
        }
    }
}
