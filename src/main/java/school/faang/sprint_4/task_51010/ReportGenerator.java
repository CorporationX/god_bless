package school.faang.sprint_4.task_51010;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class ReportGenerator {
    private final List<SalesData> salesDataList;


    public void generateReport() {
        log.info("Отчет по продажам:");
        salesDataList.forEach(salesData -> {
            log.info("Магазин №{}:", salesData.storeId());
            salesData.sales().forEach(sales -> {
                log.info("Товар: {}, Время: {}, Количество: {}",
                        sales.productId(),
                        sales.timestamp(),
                        sales.quantity());
            });
        });
    }
}
