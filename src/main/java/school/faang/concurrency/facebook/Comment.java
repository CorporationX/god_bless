package school.faang.concurrency.facebook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@ToString
public class Comment {
    private String text;
    private String author;
    private LocalDateTime time;

    public Comment(String text, String author) {
        this.text = text;
        this.author = author;
        this.time = LocalDateTime.now();
    }
}
