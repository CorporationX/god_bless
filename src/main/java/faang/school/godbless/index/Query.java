package faang.school.godbless.index;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Query {
    private int id;
    private String content;
    private final Timestamp timestamp = new Timestamp(LocalDate.now().toEpochDay());
}
