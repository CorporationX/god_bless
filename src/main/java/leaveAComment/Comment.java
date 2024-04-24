package leaveAComment;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Comment {
    private String content;
    private String author;
    private LocalDate date;

    public Comment(String content, String author) {
        this.content = content;
        this.author = author;
        this.date = LocalDate.now();
    }
}
