package school.faang.task415;

import school.faang.task415.document.CollaborativeDocument;
import school.faang.task415.document.DocumentSection;
import school.faang.task415.document.DocumentSectionProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        CollaborativeDocument collaborativeDocument = new CollaborativeDocument();
        ExecutorService service = Executors.newFixedThreadPool(10);
        List<CompletableFuture<Void>> completableFutures = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            collaborativeDocument.addData(String.valueOf(i), "Some string " + i);
            DocumentSection documentSection = new DocumentSection(i, collaborativeDocument);
            completableFutures.add(CompletableFuture.runAsync(new DocumentSectionProcessor(documentSection)));
        }

        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0])).join();

        service.shutdown();
        try {
            if(!service.awaitTermination(1, TimeUnit.MINUTES)){
                System.out.println("Ошибка, прирываем потоки");
                service.shutdown();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException(e.getStackTrace().toString());
        }

        collaborativeDocument.printAll();
    }
}
