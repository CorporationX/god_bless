package school.faang.report;

import java.util.List;

public class ReportGenerator {
    private final List<SalesData> salesDataList;

    public ReportGenerator(List<SalesData> salesDataList) {
        this.salesDataList = salesDataList;
    }

    public void generateReport() {
        System.out.println("Отчёт по продажам:");
        for (SalesData salesData : salesDataList) {
            System.out.println("Магазин: " + salesData.getStoreId());
            for (Sales sale : salesData.getSales()) {
                System.out.println("Товар: " + sale.getProductId() +
                        ", Время: " + sale.getTimestamp() +
                        ", Количество: " + sale.getQuantity());
            }
        }
    }
}

