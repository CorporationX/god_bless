package faang.school.godbless.sprint2.RecommendationSystem;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ProductOrder {
    private int userId;
    private int productId;
    private LocalDateTime orderDate;

}
