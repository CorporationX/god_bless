package faang.school;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ProductOrder {
    private int userId;
    private int productId;
    private LocalDate orderDate;
}
