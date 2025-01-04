package school.faang.task_50971;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class ReportGenerator {
    private final List<SalesData> salesDataList;

    public void generateReport() {
        log.info("Sales Report:");
        salesDataList.forEach(salesData -> {
            log.info("Store: {}", salesData.getStoreId());
            salesData.getSales().forEach(sale ->
                    log.info("Product: {}, Timestamp: {}, Quantity: {}",
                            sale.getProductId(),
                            sale.getTimestamp(),
                            sale.getQuantity())
            );
        });
    }
}
