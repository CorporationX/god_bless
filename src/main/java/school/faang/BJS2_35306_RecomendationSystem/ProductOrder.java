package school.faang.BJS2_35306_RecomendationSystem;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ProductOrder {
    private int userId;
    private int productId;
    private LocalDateTime orderDate;
}
