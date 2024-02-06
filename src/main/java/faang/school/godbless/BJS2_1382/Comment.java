package faang.school.godbless.BJS2_1382;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    private String comment;
    private User author;
    private LocalDateTime dateTime;

    public Comment(String comment, User author) {
        this.comment = comment;
        this.author = author;
        this.dateTime = LocalDateTime.now();
    }
}