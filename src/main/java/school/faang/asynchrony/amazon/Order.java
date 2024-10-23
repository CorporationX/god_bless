package school.faang.asynchrony.amazon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Order {
    private Integer id;
    private OrderStatus status;
}
