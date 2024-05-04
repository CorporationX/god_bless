package leaveAComment;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Comment {
    private String content;
    private Author author;
    private LocalDate date;

    public Comment(String content, Author author) {
        this.content = content;
        this.author = author;
        this.date = LocalDate.now();
    }
}
