package recommendation_system;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrder {
    private int userId;
    private String productId;
    private LocalDateTime orderDate;
}
