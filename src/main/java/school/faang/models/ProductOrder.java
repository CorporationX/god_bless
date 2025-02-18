package school.faang.models;

import lombok.Getter;
import school.faang.utils.ValidationUtils;

import java.time.LocalDate;

@Getter
public class ProductOrder {
    private final int userId;
    private final int productId;
    private final LocalDate orderDate;

    public ProductOrder(int userId, int productId, LocalDate orderDate) {
        ValidationUtils.isValidLocalDate(orderDate);
        this.userId = userId;
        this.productId = productId;
        this.orderDate = orderDate;
    }
}
