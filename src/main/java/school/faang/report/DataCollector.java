package school.faang.report;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class DataCollector implements Runnable {
    public String storeID;
    public CountDownLatch latch;
    public List<salesdata> salesDataList;

    public DataCollector(String id, CountDownLatch latch, List<salesdata> list) {
        this.storeID = id;
        this.latch = latch;
        this.salesDataList = list;
    }

    public List<sales> fetchSales() {
        List<sales> salesList = new ArrayList<>();
        salesList.add(new sales("ProductX", System.currentTimeMillis(), 12));
        return salesList;
    }

    @Override
    public void run() {
        List<sales> sales = fetchSales();
        salesdata data = new salesdata(storeID, sales);
        synchronized (salesDataList) {
            salesDataList.add(data);
        }
        latch.countDown();
    }
}
