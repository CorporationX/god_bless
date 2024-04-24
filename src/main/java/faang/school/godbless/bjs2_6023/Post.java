package faang.school.godbless.bjs2_6023;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = "comments")
public class Post {
    private long id;
    private String title;
    private String text;
    private String author;
    private List<Comment> comments = new ArrayList<>();

    public Post(long id, String title, String text, String author) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.author = author;
    }
}
