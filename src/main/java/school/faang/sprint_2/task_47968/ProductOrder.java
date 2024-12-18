package school.faang.sprint_2.task_47968;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
public class ProductOrder {
    private int userId;
    private int productId;
    private LocalDateTime orderDate;
}
