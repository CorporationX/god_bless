package sprint5.comment;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Post {
    private final String title;
    private final String text;
    private final String author;
    private final List<Comment> comments = new ArrayList<>();

    @Override
    public String toString() {
        return String.format("\nTitle: %s, text: %s, author: %s,\ncomments: ", title, text, author) + comments;
    }
}
