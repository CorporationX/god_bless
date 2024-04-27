package faang.school.godbless.amazon_orders;

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
