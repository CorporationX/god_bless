package the_elk_query_index;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Query {
    private int id;
    private String content;
    private int timestamp;
}
