package school.faang.bjs2_83088;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        CollaborativeDocument document = new CollaborativeDocument();

        document.addData("section1", "first section");
        document.addData("section2", "second section");
        document.addData("section3", "third section");

        DocumentSection section1 = new DocumentSection("section1", document);
        DocumentSection section2 = new DocumentSection("section2", document);
        DocumentSection section3 = new DocumentSection("section3", document);

        List<Runnable> processors = List.of(
                new DocumentSectionProcessor(section1),
                new DocumentSectionProcessor(section2),
                new DocumentSectionProcessor(section3)
        );

        ExecutorService executor = Executors.newFixedThreadPool(3);
        processors.forEach(executor::submit);
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        log.info("Section1: {}", section1.read());
        log.info("Section3: {}", section3.read());
        log.info("Final contents of the document:");
        log.info("Section2: {}", section2.read());
    }
}
