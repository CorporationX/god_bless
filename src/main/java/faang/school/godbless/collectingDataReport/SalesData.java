package faang.school.godbless.collectingDataReport;

import lombok.Getter;

import java.util.*;

@Getter
public class SalesData {
    private final int storeId;
    private final List<Sales> salesList;

    public SalesData(int storeId) {
        this.storeId = storeId;
        this.salesList = new ArrayList<>();
    }

    public void addSales(Sales sales) {
        salesList.add(sales);
    }

}
