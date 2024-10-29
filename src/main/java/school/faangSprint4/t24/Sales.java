package school.faangSprint4.t24;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class Sales {
    private final String productId;
    private final LocalDateTime timestamp;
    private final int quantity;

    @Override
    public String toString() {
        return "Sales{" +
                "productId='" + productId + '\'' +
                ", timestamp=" + timestamp +
                ", quantity=" + quantity +
                '}';
    }
}