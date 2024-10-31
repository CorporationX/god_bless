package bjs2_37889;

import javax.print.Doc;
import javax.swing.text.Document;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    private static final int TOTAL_THREADS = 5;
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(TOTAL_THREADS);

    public static void main(String[] args) {
        CollaborativeDocument collaborativeDocument = new CollaborativeDocument();

        DocumentSection header = new DocumentSection("header", collaborativeDocument);
        DocumentSection body = new DocumentSection("body", collaborativeDocument);
        DocumentSection footer = new DocumentSection("footer", collaborativeDocument);

        CompletableFuture<Void> headerWrite = CompletableFuture.runAsync(() ->
                header.write("This is header"), EXECUTOR_SERVICE);
        CompletableFuture<Void> bodyWrite = CompletableFuture.runAsync(() ->
                body.write("This is body"), EXECUTOR_SERVICE);
        CompletableFuture<Void> footerWrite = CompletableFuture.runAsync(() ->
                footer.write("This is footer"), EXECUTOR_SERVICE);
        CompletableFuture.allOf(headerWrite, bodyWrite, footerWrite).join();

        CompletableFuture<Void> headerProcess = CompletableFuture.runAsync(() ->
                new DocumentSectionProcessor(header).run(), EXECUTOR_SERVICE);
        CompletableFuture<Void> bodyProcess = CompletableFuture.runAsync(() ->
                new DocumentSectionProcessor(body).run(), EXECUTOR_SERVICE);
        CompletableFuture<Void> footerProcess = CompletableFuture.runAsync(() ->
                new DocumentSectionProcessor(footer).run(), EXECUTOR_SERVICE);
        CompletableFuture.allOf(headerProcess, bodyProcess, footerProcess).join();

        System.out.println(collaborativeDocument.getDocument());

        EXECUTOR_SERVICE.shutdown();
    }
}
