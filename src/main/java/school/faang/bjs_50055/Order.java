package school.faang.bjs_50055;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Order {
    private final int id;
    @Setter
    private OrderStatus status;
}
