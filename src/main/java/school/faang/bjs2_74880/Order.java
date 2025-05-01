package school.faang.bjs2_74880;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Order {
    private final long id;
    @Setter
    private OrderStatus status;
}
