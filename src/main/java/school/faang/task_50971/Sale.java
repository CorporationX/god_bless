package school.faang.task_50971;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class Sale {
    private final UUID productId;
    private final LocalDateTime timestamp;
    private final int quantity;
}
