package FacebookComments;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
public class Comment {
    private String text;
    private Date date;
    private String author;

    public Comment(String text, String author) {
        this.text = text;
        this.author = author;
        this.date = new Date();
    }
}
