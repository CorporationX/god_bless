package faang.school.godbless.collectingdataforthereport;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class ReportGenerator {

    public void generateReport(List<SalesData> salesDataList) {
        log.info("Generating report...");
        for (SalesData salesData : salesDataList) {
            log.info("SalesData: {}", salesData);
        }
    }
}