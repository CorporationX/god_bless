package school.faang.sprint2.task_47283;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class ProductOrder {
    private final int userId;
    private final int productId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime orderDate;

    @JsonCreator
    public ProductOrder(
            @JsonProperty("userId") int usedId,
            @JsonProperty("productId") int productId,
            @JsonProperty("orderDate") LocalDateTime orderDate) {
        this.userId = usedId;
        this.productId = productId;
        this.orderDate = orderDate;
    }
}
