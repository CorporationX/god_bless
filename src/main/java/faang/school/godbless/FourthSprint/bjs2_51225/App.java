package faang.school.godbless.FourthSprint.bjs2_51225;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    private static final int TASK_NUMBER = 15;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        CollaborativeDocument document = new CollaborativeDocument();
        List<DocumentSection> sections = List.of(
                new DocumentSection("#1", document),
                new DocumentSection("#2", document),
                new DocumentSection("#3", document),
                new DocumentSection("#4", document),
                new DocumentSection("#5", document));

        sections.forEach(a -> document.addData(a.getId(), "test"));
        sections.forEach(a -> executor.submit(new DocumentSectionProcessor(a)));

        while (!executor.isTerminated()){
            try {
                executor.awaitTermination(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        executor.shutdown();

    }
}
