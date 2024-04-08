package elk;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Query {
    private int id;
    private String content;
    private String timestamp;
}
