package school.faang.task4210;

import java.util.concurrent.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

class Sales {
    private final String productId;
    private final long timestamp;
    private final int quantity;

    public Sales(String productId, long timestamp, int quantity) {
        this.productId = productId;
        this.timestamp = timestamp;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "productId='" + productId + '\'' +
                ", timestamp=" + timestamp +
                ", quantity=" + quantity +
                '}';
    }
}

class SalesData {
    private final String storeId;
    private final List<Sales> sales;

    public SalesData(String storeId) {
        this.storeId = storeId;
        this.sales = new ArrayList<>();
    }

    public void addSale(Sales sale) {
        sales.add(sale);
    }

    public String getStoreId() {
        return storeId;
    }

    public List<Sales> getSales() {
        return sales;
    }
}

class DataCollector implements Runnable {
    private final String storeId;
    private final CountDownLatch latch;
    private final List<SalesData> salesDataList;

    public DataCollector(String storeId, CountDownLatch latch, List<SalesData> salesDataList) {
        this.storeId = storeId;
        this.latch = latch;
        this.salesDataList = salesDataList;
    }

    private List<Sales> fetchSalesFromStore() {
        List<Sales> salesList = new ArrayList<>();
        salesList.add(new Sales("P1", System.currentTimeMillis(), new Random().nextInt(100)));
        salesList.add(new Sales("P2", System.currentTimeMillis(), new Random().nextInt(100)));
        return salesList;
    }

    @Override
    public void run() {
        try {
            SalesData salesData = new SalesData(storeId);
            List<Sales> sales = fetchSalesFromStore();
            sales.forEach(salesData::addSale);
            salesDataList.add(salesData);
        } finally {
            latch.countDown();
        }
    }
}

class ReportGenerator {
    private final List<SalesData> salesDataList;

    public ReportGenerator(List<SalesData> salesDataList) {
        this.salesDataList = salesDataList;
    }

    public void generateReport() {
        System.out.println("Итоговый отчёт о продажах:");
        for (SalesData salesData : salesDataList) {
            System.out.println("Магазин: " + salesData.getStoreId());
            for (Sales sale : salesData.getSales()) {
                System.out.println(sale);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int numberOfStores = 3;
        CountDownLatch latch = new CountDownLatch(numberOfStores);
        List<SalesData> salesDataList = new ArrayList<>();

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 1; i <= numberOfStores; i++) {
            executor.submit(new DataCollector("Store " + i, latch, salesDataList));
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        ReportGenerator reportGenerator = new ReportGenerator(salesDataList);
        reportGenerator.generateReport();

        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Завершение работы системы сбора данных о продажах");
    }
}

