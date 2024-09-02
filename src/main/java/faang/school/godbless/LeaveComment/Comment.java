package faang.school.godbless.LeaveComment;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Comment {
    private String id;
    private String text;
    private LocalDateTime date;
    private String author;

    public Comment(String text, String author) {
        this.id = UUID.randomUUID().toString();
        this.text = text;
        this.date = LocalDateTime.now();
        this.author = author;
    }
}
