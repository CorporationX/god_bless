package faang.school.godbless.comments;

import lombok.Getter;

import java.util.Date;

@Getter
public class Comment {
    private String body;
    private Date date;
    private String author;

    public Comment(String body) {
        this.body = body;
        date = new Date();
        author = Thread.currentThread().getName();
    }
}
