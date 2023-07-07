package faang.school.godbless.DataCollectionForTheReport;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ReportGenerator {
    public void generateReport(List<SalesData> salesDataList) {
        salesDataList.forEach(System.out::println);
    }
}
