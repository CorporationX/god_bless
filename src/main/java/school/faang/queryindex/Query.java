package school.faang.queryindex;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Query {
    private int id;
    private String content;
    private LocalDateTime timestamp;
}
