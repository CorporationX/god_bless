package school.faangSprint4.t19;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class DocumentSectionProcessor implements Runnable {
    private final DocumentSection section;
    private static final int PROCESSING_TIME = 1000;
    private final ExecutorService executor;

    public DocumentSectionProcessor(DocumentSection section) {
        this.section = section;
        this.executor = Executors.newSingleThreadExecutor();
    }

    public void process(String data) {
        if (data != null) {
            Future<Void> future = executor.submit(() -> {
                try {
                    Thread.sleep(PROCESSING_TIME);
                    String processedData = data.toUpperCase() + " (Processed at: " +
                            java.time.LocalTime.now() + ")";
                    section.write(processedData);
                } catch (InterruptedException e) {
                    System.err.println("Processing interrupted: " + e.getMessage());
                }
                return null;
            });

            try {
                 future.get(2 * PROCESSING_TIME, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                future.cancel(true);
                System.err.println("Processing failed or timed out: " + e.getMessage());
            }
        }
    }

    @Override
    public void run() {
        System.out.println("Starting processing for section: " + section.id());
        String currentData = section.read();
        process(currentData);
        System.out.println("Finished processing section " + section.id() +
                ": " + section.read());

        shutdownExecutor();
    }

    public void shutdownExecutor() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(2 * PROCESSING_TIME, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}