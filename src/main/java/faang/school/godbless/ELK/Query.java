package faang.school.godbless.ELK;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@ToString
@AllArgsConstructor
public class Query {
    private int id;
    private String content;
    private Timestamp timestamp;
}
