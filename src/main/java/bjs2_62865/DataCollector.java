package bjs2_62865;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

@RequiredArgsConstructor
public class DataCollector implements Runnable {
    private final int storeId;
    private final CountDownLatch latch;
    private final List<SalesData> salesDataList;

    public List<Sales> fetchSalesFromStore() {
        List<Sales> salesList = new ArrayList<>();

        Random random = new Random();
        // Например, генерируем 5 продаж для магазина
        for (int i = 1; i <= 5; i++) {
            int productId = i;
            LocalDateTime timestamp = LocalDateTime.now();
            int quantity = random.nextInt(100); // случайное количество продаж
            salesList.add(new Sales(productId, timestamp, quantity));
        }

        return salesList;
    }

    @Override
    public void run() {
        var sales = fetchSalesFromStore();
        var salesData = new SalesData(storeId, sales);

        synchronized (salesDataList) {
            salesDataList.add(salesData);
        }

        latch.countDown();
    }
}
