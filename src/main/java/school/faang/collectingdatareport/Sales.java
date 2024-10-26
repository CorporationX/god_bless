package school.faang.collectingdatareport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Sales {
    private final String productId;
    private final LocalDateTime timestamp;
    private final int quantity;
}

