package faang.school.godbless.elk_index_queries;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Query {
    private int id;
    private long timeStamp;
    private String content;
}
