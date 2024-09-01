package faang.school.godbless.BJS2_25280;

import lombok.AllArgsConstructor;

import java.util.concurrent.Callable;

@AllArgsConstructor
public class DataCollector implements Callable<Integer> {
    private Store store;

    @Override
    public Integer call() throws Exception {
        System.out.println("Fetching sales data...");
        Thread.sleep(5000L);

        SalesData salesData = store.fetchSalesData();
        return salesData.getSales().stream()
                .mapToInt(Sales::getCount)
                .sum();
    }
}
