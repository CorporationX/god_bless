package faang.school.godbless.recomend_sys;

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
