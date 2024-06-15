package faang.school.godbless.task_16_LRU_Cache;

import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@lombok.Data
@AllArgsConstructor
public class Data {
    private int id;
    private int value;
    private LocalDateTime timestamp;
}
