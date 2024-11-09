package school.faang.report;

import java.util.List;

public class SalesData {
    private String storeId;
    private List<Sales> sales;

    public SalesData(String storeId, List<Sales> sales) {
        this.storeId = storeId;
        this.sales = sales;
    }

    public String getStoreId() {
        return storeId;
    }

    public List<Sales> getSales() {
        return sales;
    }
}

