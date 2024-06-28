package faang.school.godbless.OrdersInAmazon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Order {
    private int id;
    @Setter
    private String status;

}
