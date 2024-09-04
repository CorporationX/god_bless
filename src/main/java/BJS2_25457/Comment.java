package BJS2_25457;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Comment {
    private String text;
    private final String author;
    private final LocalDateTime dateTime = LocalDateTime.now();
}
