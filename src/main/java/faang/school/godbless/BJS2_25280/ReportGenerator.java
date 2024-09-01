package faang.school.godbless.BJS2_25280;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

@AllArgsConstructor
public class ReportGenerator {
    private List<Store> stores;
    private ExecutorService executor;

    public void generateReport() {
        var salesData = stores.stream()
                .map(store -> executor.submit(new DataCollector(store)))
                .toList();

        salesData.forEach(future -> CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Количество проданного товара: "  + future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }));
        System.out.println();
    }
}
