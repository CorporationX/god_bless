package collecting_orders_on_amazon;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Order {
    private final int id;
    private Status status = Status.ADDED;
}
