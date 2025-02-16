package school.faang;

import java.time.OffsetDateTime;

public record ProductOrder(int userId, int productId, String orderDate) {
}
