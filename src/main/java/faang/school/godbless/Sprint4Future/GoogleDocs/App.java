package faang.school.godbless.Sprint4Future.GoogleDocs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        CollaborativeDocument document = new CollaborativeDocument();

        DocumentSection section1 = new DocumentSection("1", document);
        DocumentSection section2 = new DocumentSection("2", document);
        DocumentSection section3 = new DocumentSection("3", document);
        DocumentSection section4 = new DocumentSection("4", document);

        section1.addData("Section1 data");
        section2.addData("Section2 data");
        section3.addData("Section3 data");
        section4.addData("Section4 data");

        DocumentSectionProcessor processor1 = new DocumentSectionProcessor(section1);
        DocumentSectionProcessor processor2 = new DocumentSectionProcessor(section2);
        DocumentSectionProcessor processor3 = new DocumentSectionProcessor(section3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(processor1);
        executorService.execute(processor2);
        executorService.execute(processor3);

        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(section1.getData());
        document.getDocument().entrySet().forEach(System.out::println);

    }
}
