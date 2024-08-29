package faang.school.godbless;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ProductOrder {
    private int userId;
    private int productId;
    private LocalDateTime orderDate;

    public ProductOrder(int userId, int productId, LocalDateTime orderDate) {
        this.userId = userId;
        this.productId = productId;
        this.orderDate = orderDate;
    }
}
