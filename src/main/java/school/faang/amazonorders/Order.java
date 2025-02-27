package school.faang.amazonorders;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private final int id;
    private String status;
}
