package faang.school.godbless.LeaveComment;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Comment {
    private String commentText;
    private String author;
    private LocalDateTime dateTime;

    public Comment(String commentText, String author) {
        this.commentText = commentText;
        this.author = author;
    }
}
