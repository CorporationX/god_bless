package faang.school.godbless.bjs2_5319;

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
