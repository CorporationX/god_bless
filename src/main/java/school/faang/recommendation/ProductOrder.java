package school.faang.recommendation;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class ProductOrder {
    private final int userId;
    private final int productId;
    private String orderDate;
}
