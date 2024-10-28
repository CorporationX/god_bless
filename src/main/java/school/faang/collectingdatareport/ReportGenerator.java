package school.faang.collectingdatareport;

import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class ReportGenerator {
    private final List<SalesData> salesDataList;

    public void generateReport() {
        System.out.println("Sales Report:");
        for (SalesData salesData : salesDataList) {
            System.out.println("Store ID: " + salesData.getStoreId());
            for (Sales sale : salesData.getSales()) {
                System.out.println("Product ID: " + sale.getProductId() + ", Quantity: " + sale.getQuantity() +
                        ", Timestamp: " + sale.getTimestamp());
            }
            System.out.println("------------");
        }
    }
}

