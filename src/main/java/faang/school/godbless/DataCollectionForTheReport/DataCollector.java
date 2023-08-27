package faang.school.godbless.DataCollectionForTheReport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class DataCollector extends Thread {
    private CountDownLatch countDownLatch;
    private SalesData salesData;

    public void fetchSalesFromStore() {
        List<Sales> sales = new ArrayList<>();
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(5, 10); i++) {
            sales.add(new Sales(i + 1, LocalDateTime.now(),
                    ThreadLocalRandom.current().nextInt(10)));
        }

        salesData.getSalesList().addAll(sales);
    }

    @Override
    public void run() {
        fetchSalesFromStore();
        countDownLatch.countDown();
    }
}
