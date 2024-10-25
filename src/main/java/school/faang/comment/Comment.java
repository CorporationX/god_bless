package school.faang.comment;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Comment {
    private String text;
    private String author;
    private LocalDateTime timestamp;

    @Override
    public String toString() {
        return "\nComment " + text + '\n' +
                "author = " + author + '\n' +
                "timestamp = " + timestamp;
    }
}
