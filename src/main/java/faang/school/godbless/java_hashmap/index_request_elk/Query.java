package faang.school.godbless.java_hashmap.index_request_elk;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Query {

    private int id;
    private String content;
    private LocalDateTime timestamp;


}
