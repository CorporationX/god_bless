package faang.school.godbless.Comments;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    private String text;
    private LocalDateTime postTime;
    private String author;

    public Comment(String text, String author) {
        this.text = text;
        this.author = author;
        postTime = LocalDateTime.now();
    }
}
