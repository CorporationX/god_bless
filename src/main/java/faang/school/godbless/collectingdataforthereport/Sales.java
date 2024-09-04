package faang.school.godbless.collectingdataforthereport;

import java.time.LocalDateTime;

public record Sales(int productId, LocalDateTime timestamp, int quantity) {
}