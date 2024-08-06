package faang.school.godbless.BJS2_19748;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Query {
    private int id;
    private String context;
    private LocalDateTime timestamp = LocalDateTime.now();
}
