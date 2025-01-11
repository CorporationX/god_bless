package derschrank.sprint04.task24.bjstwo_50961;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ReportGenerator {
    private List<SalesData> salesDataList;

    public void generateReport(List<Integer> stores) {
        final int countOfStores = stores.size();
        final CountDownLatch latch = new CountDownLatch(countOfStores);

        List<? extends Collector> collectors = stores.stream()
                .map(id -> new DataCollector(id, latch))
                .toList();

        collectors.stream().map(Thread::new).forEach(Thread::start);

        latchAwait(latch);

        salesDataList = collectors.stream()
                .map(Collector::fetchSalesFromStore)
                .toList();

        System.out.println("REPORT OF STORES:");
        salesDataList.forEach(System.out::println);
    }

    private static void latchAwait(CountDownLatch latch) {
        try {
            latch.await();
        } catch (InterruptedException e) {
            System.out.println("ReportGenerator was interrupted.\n" + e);
        }
    }
}
