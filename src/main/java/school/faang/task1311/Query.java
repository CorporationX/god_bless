package school.faang.task1311;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@AllArgsConstructor
@ToString
@Data
public class Query {

    private int id;
    private String content;
    private int timestamp;
}
