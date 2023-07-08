package faang.school.godbless.kxnvg.googledocs;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

    @SneakyThrows
    public static void main(String[] args) {
        CollaborativeDocument document = new CollaborativeDocument();

        DocumentSection section1 = new DocumentSection("first", "INFORMATION");
        DocumentSection section2 = new DocumentSection("second", "this is very important doc");
        DocumentSection section3 = new DocumentSection("third", "some errors");
        DocumentSection section4 = new DocumentSection("fourth", "info: ... ");
        DocumentSection section5 = new DocumentSection("fives", "The end.");

        document.addDocumentSection(section1.getId(), section1.getData());
        document.addDocumentSection(section2.getId(), section2.getData());
        document.addDocumentSection(section3.getId(), section3.getData());
        document.addDocumentSection(section4.getId(), section4.getData());
        document.addDocumentSection(section5.getId(), section5.getData());

        DocumentSectionProcessor processor1 = new DocumentSectionProcessor(section1, "down");
        DocumentSectionProcessor processor2 = new DocumentSectionProcessor(section2, "up");
        DocumentSectionProcessor processor3 = new DocumentSectionProcessor(section3, "clear");
        DocumentSectionProcessor processor4 = new DocumentSectionProcessor(section4, "update");
        DocumentSectionProcessor processor5 = new DocumentSectionProcessor(section5, "command");

        ExecutorService service = Executors.newFixedThreadPool(5);

        service.execute(processor1);
        service.execute(processor2);
        service.execute(processor3);
        service.execute(processor4);
        service.execute(processor5);

        service.shutdown();
        service.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println(document.getDocumentSection("first"));
        System.out.println(document.getDocumentSection("second"));
        System.out.println(document.getDocumentSection("third"));
        System.out.println(document.getDocumentSection("fourth"));
        System.out.println(document.getDocumentSection("fives"));
    }
}
