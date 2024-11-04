package school.faangSprint4.t24;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

@AllArgsConstructor
public class DataCollector implements Runnable {
    private final String storeId;
    private final CountDownLatch latch;
    private final List<SalesData> globalSalesList;

    private List<Sales> fetchSalesFromStore() {
        List<Sales> sales = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < random.nextInt(5) + 1; i++) {
            Sales sale = new Sales(
                    "PROD-" + (random.nextInt(100) + 1),
                    LocalDateTime.now().minusHours(random.nextInt(24)),
                    random.nextInt(10) + 1
            );
            sales.add(sale);
        }
        return sales;
    }

    @Override
    public void run() {
        try {
            System.out.println("Начало сбора данных для магазина: " + storeId);

            List<Sales> storeSales = fetchSalesFromStore();

            SalesData salesData = new SalesData(storeId);
            for (Sales sale : storeSales) {
                salesData.addSales(sale);
            }

            synchronized (globalSalesList) {
                globalSalesList.add(salesData);
            }

            System.out.println("Завершен сбор данных для магазина: " + storeId);
        } finally {
            latch.countDown();
        }
    }
}