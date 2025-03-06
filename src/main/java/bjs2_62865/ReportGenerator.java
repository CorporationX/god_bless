package bjs2_62865;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class ReportGenerator {
    private final List<SalesData> salesDataList;

    public void generateReport() {
        log.info("Генерация отчёта");
        salesDataList.stream()
                .sorted(Comparator.comparingInt(SalesData::storeId))
                .forEach(salesData -> {
                    log.info("Магазин {}", salesData.storeId());
                    for (var sales : salesData.sales()) {
                        log.info(
                                "Продажа {} единиц продукта {} в {}",
                                sales.quantity(),
                                sales.productId(),
                                sales.timestamp());
                    }
                });
    }
}
