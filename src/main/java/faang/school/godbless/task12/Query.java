package faang.school.godbless.task12;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class Query {
    private int id;
    private String content;
    private LocalDateTime date;
}
