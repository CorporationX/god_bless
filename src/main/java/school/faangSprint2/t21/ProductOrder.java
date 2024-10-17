package school.faangSprint2.t21;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ProductOrder {
    private String userId;
    private String productId;
    private LocalDateTime orderDate;
}