package faang.school;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
@AllArgsConstructor
@Data
public class Comment {
    private String name;
    private String text;
    private Instant time;
    private String author;
}
