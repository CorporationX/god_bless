package faang.school.godbless.BJS2_25280;

import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
public class Store {
    public static ThreadLocalRandom random = ThreadLocalRandom.current();
    private static ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
    private static AtomicInteger counter = new AtomicInteger(1);

    private final int id;
    private List<Sales> sales = new LinkedList<>();

    public SalesData fetchSalesData() {
        int size = sales.size();
        if (size >= 20) {
            List<Sales> partForReport = sales.subList(size - 21, size);
            return new SalesData(id, partForReport);
        }
        return new SalesData(id, sales);
    }

    public void openStore() {
        executor.scheduleAtFixedRate(() -> {
            System.out.printf("Store %s working...%n", id);
            Sales sale = new Sales(
                    counter.getAndIncrement(),
                    System.currentTimeMillis(),
                    random.nextInt(1, 100)
            );
            sales.add(sale);
        }, 0, random.nextInt(1, 60), TimeUnit.SECONDS);
    }
}
