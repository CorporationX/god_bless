package queryIndex;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class Query {
    private int id;
    private String content;
    private LocalDateTime timestamp;
}
