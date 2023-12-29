package faang.school.godbless.multi_con.task1comment;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Comment {
    private String text;
    private LocalDateTime dateTime;
    private String author;

    public Comment(String text, String author) {
        this.text = text;
        this.author = author;
        this.dateTime = LocalDateTime.now();
    }
}
