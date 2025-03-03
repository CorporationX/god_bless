package school.faang.amazon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Order {
    private int id;
    private OrderStatus status;
}
