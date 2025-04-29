package school.faang.bjs2_71088;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class ProductOrder {
    private int userId;
    private int productId;
    LocalDateTime orderDate;
}
