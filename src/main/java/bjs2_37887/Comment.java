package bjs2_37887;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode
public class Comment {
    private String text;
    private String author;
    private LocalDateTime timestamp;

    public Comment(String text, String author) {
        this.text = text;
        this.author = author;
        timestamp = LocalDateTime.now();
    }
}
