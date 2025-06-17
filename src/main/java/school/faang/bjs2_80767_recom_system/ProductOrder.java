package school.faang.bjs2_80767_recom_system;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record ProductOrder(
        int userId,
        int productId,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime orderDate
) {
}

