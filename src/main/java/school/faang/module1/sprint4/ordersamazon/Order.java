package school.faang.module1.sprint4.ordersamazon;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private final int id;
    private String status;
}
