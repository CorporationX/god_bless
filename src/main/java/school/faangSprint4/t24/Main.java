package school.faangSprint4.t24;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Main {
    private static final int STORES = 3;

    public static void main(String[] args) {
        try {
            List<SalesData> globalSalesList = new ArrayList<>();

            CountDownLatch latch = new CountDownLatch(STORES);

            for (int i = 0; i < STORES; i++) {
                String storeId = "STORE-" + (i + 1);
                DataCollector collector = new DataCollector(storeId, latch, globalSalesList);
                new Thread(collector).start();
            }

            System.out.println("Ожидание завершения сбора данных...");
            latch.await();

            ReportGenerator reporter = new ReportGenerator(globalSalesList);
            reporter.generateReport();

        } catch (InterruptedException e) {
            System.err.println("Процесс сбора данных был прерван: " + e.getMessage());
        }
    }
}