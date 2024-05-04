package leave_a_comment;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Comment {
    private String text;
    private User author;
    private LocalDate date;

    public Comment(String text, User author) {
        this.text = text;
        this.author = author;
        this.date = LocalDate.now();
    }
}
