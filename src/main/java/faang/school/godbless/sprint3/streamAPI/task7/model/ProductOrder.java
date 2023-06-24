package faang.school.godbless.sprint3.streamAPI.task7.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ProductOrder {

    private int userId;

    private int productId;

    private LocalDateTime orderDate;
}
