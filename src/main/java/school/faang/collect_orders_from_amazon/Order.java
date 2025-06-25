package school.faang.collect_orders_from_amazon;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class Order {
    private final int id;
    private final String status;
}