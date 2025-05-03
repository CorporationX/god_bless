package commentcreation;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class Comment {
    public String text;
    public String author;
    public LocalDateTime timestamp;
}
