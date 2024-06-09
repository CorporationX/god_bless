package faang.school.godbless.indexOfRequests;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Query {

    private String id;
    private String content;
    private LocalDateTime timestamp;
}
