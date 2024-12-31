package school.faang.sprint_4.task_50951;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RequiredArgsConstructor
@Getter
@ToString
public class SalesData {
    private final int storeId;
    private final List<Sales> sales = new CopyOnWriteArrayList<>();

    public void addSales(Sales sale) {
        sales.add(sale);
    }

    public void removeSales(Sales sale) {
        sales.remove(sale);
    }

    public List<Sales> getSales() {
        return List.copyOf(sales);
    }
}
