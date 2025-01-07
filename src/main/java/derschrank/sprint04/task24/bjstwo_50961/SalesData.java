package derschrank.sprint04.task24.bjstwo_50961;

import java.util.ArrayList;
import java.util.List;

public record SalesData(
        int storeId,
        List<Sale> sales
) {
    public List<Sale> getSales() {
        return new ArrayList<>(sales);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(String.format("STORE: %d%n", storeId));
        sales.forEach(s -> result.append(" -> ").append(s).append("\n"));
        return result.toString();
    }
}