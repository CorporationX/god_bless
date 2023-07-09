package faang.school.godbless.comment;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class Post {
    private static int counter;
    private int id = counter;
    private final String header;
    private final String text;
    private final User author;
    private List<Comment> comments = new ArrayList<>();

    public Post(String header, String text, User author) {
        this.header = header;
        this.text = text;
        this.author = author;
        counter++;
    }
}
