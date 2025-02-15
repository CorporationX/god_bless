package school.faang.models;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ProductOrder {
    private final int userId;
    private final int productId;
    private final LocalDate orderDate;

    public ProductOrder(int userId, int productId, LocalDate orderDate) {
        validateOrderDate(orderDate);
        this.userId = userId;
        this.productId = productId;
        this.orderDate = orderDate;
    }

    private void validateOrderDate(LocalDate orderDate) {
        if (orderDate == null) {
            throw new IllegalArgumentException("The orderDate can't be null or empty.");
        }
    }
}
