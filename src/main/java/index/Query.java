package index;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Query {
    private int id;
    private String content;
    private int timestamp;
}
