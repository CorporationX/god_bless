package faang.school.godbless.sprint4.comments;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    private String textComment;
    private String author;
    private LocalDateTime date;

    public Comment(String text, String author) {
        this.textComment = text;
        this.date = LocalDateTime.now();
        this.author = author;
    }
}
