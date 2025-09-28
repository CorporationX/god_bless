package school.faang.bjs2_93198;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Order {

    private final int id;
    private OrderStatus status;
}
