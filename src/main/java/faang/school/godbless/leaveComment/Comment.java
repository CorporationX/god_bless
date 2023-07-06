package faang.school.godbless.leaveComment;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    private String textComment;
    private String author;
    private LocalDateTime date;

    public Comment(String textComment, String author) {
        this.textComment = textComment;
        this.author = author;
        this.date = LocalDateTime.now();
    }

}
