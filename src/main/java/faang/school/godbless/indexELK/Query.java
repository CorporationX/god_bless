package faang.school.godbless.indexELK;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Query {
    int id;
    String content;
    Date timestamp;
}
