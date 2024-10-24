package school.faang.collect.orders.amazon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Order {
    private int id;

    @Setter
    private String status;
}
