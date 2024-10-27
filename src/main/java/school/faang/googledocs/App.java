package school.faang.googledocs;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        CollaborativeDocument document = new CollaborativeDocument();

        List<DocumentSection> sections = Arrays.asList(
                new DocumentSection("Introduction", document),
                new DocumentSection("Conclusion", document)
        );

        List<String> data = Arrays.asList(
                "hello, this is the introduction.",
                "this is the conclusion."
        );

        ExecutorService executor = Executors.newFixedThreadPool(sections.size());

        for (int i = 0; i < sections.size(); i++) {
            executor.submit(new DocumentSectionProcessor(sections.get(i), data.get(i)));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        for (DocumentSection section : sections) {
            System.out.println(String.format("Final content in %s: %s", section.getId(), section.read()));
        }
    }
}

