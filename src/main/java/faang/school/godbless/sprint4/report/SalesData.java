package faang.school.godbless.sprint4.report;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class SalesData {
    private int storeId;
    private List<Sales> salesList;

    public SalesData(int storeId) {
        this.storeId = storeId;
        this.salesList = new ArrayList<>();
    }
    public void addSale(int productId, long timestamp, int quantity) {
        Sales sale = new Sales(productId, timestamp, quantity);
        salesList.add(sale);
    }

    public List<Sales> getSalesList() {
        return salesList;
    }
}
