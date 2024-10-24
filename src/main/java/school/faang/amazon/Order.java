package school.faang.amazon;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private Integer id;
    private String status;
}
