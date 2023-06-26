package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ProductOrder {
    private int userId;
    private int productId;
    private String orderDate;
}
