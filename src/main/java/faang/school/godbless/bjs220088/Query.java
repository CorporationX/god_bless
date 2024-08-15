package faang.school.godbless.bjs220088;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class Query {
    private int id;
    private String content;
    private Instant timestamp;
}
