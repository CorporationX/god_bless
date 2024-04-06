package elk;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Date;

@AllArgsConstructor
@Getter
public class Query {
    private int id;
    private String content;
    private Date timestamp;
}
