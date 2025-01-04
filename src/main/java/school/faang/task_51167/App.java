package school.faang.task_51167;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class App {
    public static void main(String[] args) {
        CollaborativeDocument collaborativeDocument = new CollaborativeDocument();

        List<DocumentSection> sections = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            DocumentSection section = new DocumentSection("section" + i, collaborativeDocument);
            section.write("Initial data for section " + i);
            sections.add(section);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (DocumentSection section : sections) {
            DocumentSectionProcessor processor = new DocumentSectionProcessor(section);
            executorService.submit(processor);
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            log.error("Принудительное завершение задачи" + e);
        }

        for (DocumentSection section : sections) {
            System.out.println("Финальные данные в " + section.getId() + ": " + section.read());
        }
    }
}
