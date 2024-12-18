package school.faang.sprint_2.task_47311;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record ProductOrder(int userId,
                           int productId,
                           @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime orderDate) {
}
