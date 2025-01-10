package school.faang.sprint_4.task_50951;

import java.util.concurrent.ConcurrentHashMap;

public class ReportGenerator {
    private final ConcurrentHashMap<Integer, SalesData> salesDataList = new ConcurrentHashMap<>();

    public void addSalesData(SalesData salesData) {
        salesDataList.put(salesData.getStoreId(), salesData);
    }

    public SalesData getSalesDataByStoreId(int storeId) {
        return salesDataList.get(storeId);
    }

    public void generateReport() {
        salesDataList.values().forEach(System.out::println);
    }
}
