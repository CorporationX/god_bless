package faang.school.godbless.collectingDataReport;

import java.util.*;

public class ReportGenerator {
    public void generateReport(List<SalesData> salesDataList) {
        System.out.println("Generating report");

        for (SalesData salesData : salesDataList) {
            System.out.println("Store " + salesData.getStoreId());
            for (Sales sales : salesData.getSalesList()) {
                System.out.println("Product Id: " + sales.getProductId() +
                        ", Timestamp: " + sales.getTimestamp() +
                        ", Quantity: " + sales.getQuantity());
            }
        }
    }

}
