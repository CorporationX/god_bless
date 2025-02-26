package school.faang.wecollectordersfromamazon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Order {
    private final int id;
    private OrderStatus status;
}