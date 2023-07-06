package faang.school.godbless.sprint4.report;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class ReportGenerator {
    private List<SalesData> salesData;

    public void updateData(List<SalesData> salesData) {
        this.salesData = salesData;
    }
    public void generateReport() {
        for (SalesData salesData : salesData) {
            System.out.println(salesData);
        }
    }
}
