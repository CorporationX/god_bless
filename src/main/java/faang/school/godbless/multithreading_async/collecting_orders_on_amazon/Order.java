package faang.school.godbless.multithreading_async.collecting_orders_on_amazon;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private int id;
    private int status;
}
