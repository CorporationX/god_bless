package faang.school.godbless.collectingDataReport;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Sales {
    private final int productId;
    private final LocalDateTime timestamp;
    private final int quantity;
}
