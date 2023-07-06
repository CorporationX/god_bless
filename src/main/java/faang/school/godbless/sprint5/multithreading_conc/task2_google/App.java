package faang.school.godbless.sprint5.multithreading_conc.task2_google;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) {
        CollaborativeDocument document = new CollaborativeDocument();
        document.put("1", "hello");
        document.put("2", "world");
        document.put("3", "!");
        document.put("4", "qwerty");
        document.put("5", "ialab");

        DocumentSection documentSection1 = new DocumentSection("1", document);
        DocumentSection documentSection2 = new DocumentSection("2", document);
        DocumentSection documentSection3 = new DocumentSection("3", document);
        DocumentSection documentSection4 = new DocumentSection("4", document);
        DocumentSection documentSection5 = new DocumentSection("5", document);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(new DocumentSectionProcessor(documentSection1));
        executor.execute(new DocumentSectionProcessor(documentSection2));
        executor.execute(new DocumentSectionProcessor(documentSection3));
        executor.execute(new DocumentSectionProcessor(documentSection4));
        executor.execute(new DocumentSectionProcessor(documentSection5));

        executor.shutdown();
    }
}
