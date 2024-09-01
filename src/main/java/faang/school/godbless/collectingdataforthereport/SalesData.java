package faang.school.godbless.collectingdataforthereport;

import java.util.List;

public record SalesData(int storeId, List<Sales> sales) {
}