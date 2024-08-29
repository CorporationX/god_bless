package commenting;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Comment {
    private String text;
    private final LocalDateTime timestamp;
    private final String author;
}
