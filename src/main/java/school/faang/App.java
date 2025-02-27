package school.faang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        CollaborativeDocument document = new CollaborativeDocument();

        DocumentSection section1 = new DocumentSection("section1", document);
        DocumentSection section2 = new DocumentSection("section2", document);
        DocumentSection section3 = new DocumentSection("section3", document);
        section1.write("hello");
        section2.write("world");
        section3.write("java");

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new DocumentSectionProcessor(section1));
        executorService.submit(new DocumentSectionProcessor(section2));
        executorService.submit(new DocumentSectionProcessor(section3));

        executorService.shutdown();
    }
}
