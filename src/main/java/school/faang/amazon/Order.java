package school.faang.amazon;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Order {
    private final int id;
    private String status;
}
