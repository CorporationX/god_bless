package derschrank.sprint04.task24.bjstwo_50961;

import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class DataCollector implements Collector {
    private static final int SALES_PRO_STORE = 10;

    private final int storeId;
    private final CountDownLatch latch;
    private SalesData data;

    public DataCollector(int storeId, CountDownLatch latch) {
        this.storeId = storeId;
        this.latch = latch;
    }

    @Override
    public void run() {
        data = makeAndGetSalesData();
        latch.countDown();
    }

    @Override
    public SalesData fetchSalesFromStore() {
        return data;
    }

    private SalesData makeAndGetSalesData() {
        List<Sale> sales = generateRandomSales();
        return new SalesData(storeId, sales);
    }

    private List<Sale> generateRandomSales() {
        int articul0 = 10_000;
        int daysPeriod = 2;
        int quantityMulti = 5;

        List<Sale> sales = new LinkedList<>();
        for (int i = 0; i < SALES_PRO_STORE; i++) {
            LocalDate dateStamp = LocalDate.now();
            sales.add(
                    new Sale(
                            i + articul0,
                            dateStamp.minus(Period.ofDays(i * daysPeriod)),
                            i * quantityMulti + storeId
                    )
            );
        }
        return sales;
    }
}