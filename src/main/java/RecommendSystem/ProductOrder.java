package RecommendSystem;

import java.time.LocalDateTime;

public class ProductOrder {
    private int userId;
    private int productId;
    private LocalDateTime orderDate;

    public ProductOrder(int userId, int productId, LocalDateTime orderDate) {
        this.userId = userId;
        this.productId = productId;
        this.orderDate = orderDate;
    }

    public int getUserId() {
        return userId;
    }

    public int getProductId() {
        return productId;
    }

}

