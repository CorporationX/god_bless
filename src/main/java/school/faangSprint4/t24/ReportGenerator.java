package school.faangSprint4.t24;

import java.util.List;

public class ReportGenerator {
    private List<SalesData> salesDataList;

    public ReportGenerator(List<SalesData> salesDataList) {
        this.salesDataList = salesDataList;
    }

    public void generateReport() {
        System.out.println("\n=== Отчет по продажам ===");

        for (SalesData storeData : salesDataList) {
            System.out.println("\nМагазин: " + storeData.getStoreId());
            System.out.println("Количество продаж: " + storeData.getSales().size());

            System.out.println("Детали продаж:");
            for (Sales sale : storeData.getSales()) {
                System.out.println(sale);
            }
        }

        System.out.println("\n=== Конец отчета ===");
    }
}
