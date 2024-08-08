package faang.school.godbless.javahashmap.index;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Query {
    private int id;
    private String content;
    @Getter
    private long timestamp;
}
