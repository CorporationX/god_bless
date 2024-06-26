package faang.school.godbless.collectingOrdersOnAmazon;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private int id;
    private Status status;
}
