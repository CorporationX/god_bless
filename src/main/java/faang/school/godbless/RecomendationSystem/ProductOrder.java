package faang.school.godbless.RecomendationSystem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrder {
    private int userId;
    private int productId;
    private LocalDate orderDate;

}
