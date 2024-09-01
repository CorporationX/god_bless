package faang.school.godbless.BJS2_25288;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Comment {
    private String comment;
    private LocalDateTime dateTime;
    private String author;

    public Comment(String comment, String author) {
        this.comment = comment;
        this.author = author;
        this.dateTime = LocalDateTime.now();
    }
}
