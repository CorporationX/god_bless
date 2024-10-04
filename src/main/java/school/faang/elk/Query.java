package school.faang.elk;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Query {
    private Integer id;
    private String content;
    private LocalDateTime timestamp;
}
