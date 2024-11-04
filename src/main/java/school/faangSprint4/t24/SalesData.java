package school.faangSprint4.t24;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SalesData {
    private String storeId;
    private List<Sales> sales;

    public SalesData(String storeId) {
        this.storeId = storeId;
        this.sales = new ArrayList<>();
    }

    public void addSales(Sales sale) {
        sales.add(sale);
    }
}