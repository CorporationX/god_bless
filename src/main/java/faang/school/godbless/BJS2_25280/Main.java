package faang.school.godbless.BJS2_25280;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Store> stores = List.of(
                new Store(1),
                new Store(2),
                new Store(3)
        );
        ExecutorService executor = Executors.newFixedThreadPool(20);
        ReportGenerator reportGenerator = new ReportGenerator(stores, executor);

        stores.forEach(Store::openStore);
        IntStream.range(0, 10).forEach(i -> reportGenerator.generateReport());

        System.out.println("End...");
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
