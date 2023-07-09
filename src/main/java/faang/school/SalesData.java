package faang.school;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class SalesData {
    private int storeId;
    private List<Sale> sales;
}
