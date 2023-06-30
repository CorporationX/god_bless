package faang.school.godbless.recommendationSystem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductOrder {
    private int userId;
    private int productId;
    private String orderDate;
}
