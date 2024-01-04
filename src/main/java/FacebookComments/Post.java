package FacebookComments;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Post {
    private String name;
    private String text;
    private String author;
    private List<Comment> comments = new ArrayList<>();

    public Post(String name, String text, String author) {
        this.name = name;
        this.text = text;
        this.author = author;
    }
}
