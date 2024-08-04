package elk_indexation;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class Query {
    private int id;
    private String content;
    private LocalTime timestamp;
}
