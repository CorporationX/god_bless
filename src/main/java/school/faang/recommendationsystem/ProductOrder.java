package school.faang.recommendationsystem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrder {
    private int userId;
    private int productId;
    private LocalDateTime orderDate;
}

