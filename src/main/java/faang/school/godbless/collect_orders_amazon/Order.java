package faang.school.godbless.collect_orders_amazon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Order {
    private final int id;
    @Setter
    private String status;
}
