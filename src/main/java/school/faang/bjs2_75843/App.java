package school.faang.bjs2_75843;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class App {
    private static final int NUM_THREADS = 5;
    private static final int MAX_EXPECTATION = 60;

    public static void main(String[] args) {
        ExecutorService poolThreads = Executors.newFixedThreadPool(NUM_THREADS);

        CollaborativeDocument document = new CollaborativeDocument();

        IntStream.range(0, NUM_THREADS)
                .forEach(i -> {
                    DocumentSection section = new DocumentSection(String.valueOf(i), document);
                    DocumentSectionProcessor processor = new DocumentSectionProcessor(section);
                    poolThreads.execute(processor);
                });

        shutdownPool(poolThreads);
    }

    private static void shutdownPool(ExecutorService pool) {
        pool.shutdown();
        try {
            boolean isClose = pool.awaitTermination(MAX_EXPECTATION, TimeUnit.SECONDS);
            if (!isClose) {
                pool.shutdownNow();
            }
        } catch (InterruptedException ex) {
            log.error("Thread stopped exception");
            pool.shutdownNow();
        }
    }
}
