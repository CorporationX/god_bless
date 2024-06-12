package faang.school.godbless.task15;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class Query {
    private String id;
    private String content;
    private Timestamp timestamp;
}
