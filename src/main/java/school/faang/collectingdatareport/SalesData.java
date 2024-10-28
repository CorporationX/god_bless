package school.faang.collectingdatareport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@Getter
@AllArgsConstructor
public class SalesData {
    private final String storeId;
    private final List<Sales> sales;
}

