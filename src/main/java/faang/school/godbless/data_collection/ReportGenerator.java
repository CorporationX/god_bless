package faang.school.godbless.data_collection;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class ReportGenerator {
    public void showReport(List<SalesData> salesDataList) {
        salesDataList.forEach(
                salesData -> salesData.getSalesMap().values()
                        .forEach(sales -> log.info(String.valueOf(sales))));
    }
}
