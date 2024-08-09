package faang.school.godbless.inedxELK;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Query {
    private long id;
    private String content;
    private long timestamp;
}
