package faang.school;

import java.util.List;

public class ReportGenerator {
    public void generateReport(List<SalesData> allSalesData) {
        System.out.println("----- Sales Report -----");

        for (SalesData salesData : allSalesData) {
            System.out.println("Store ID: " + salesData.getStoreId());
            List<Sale> sales = salesData.getSales();
            if (sales.isEmpty()) {
                System.out.println("No sales data available for this store.");
            } else {
                System.out.println("Sales:");
                for (var sale : sales) {
                    System.out.println("Product ID: " + sale.getProductId());
                }
            }
            System.out.println("------------------------");
        }
    }
}
