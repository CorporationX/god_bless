package school.faang.bjs2_93200;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Order {
    private int id;
    @Setter private OrderStatus status;
}
