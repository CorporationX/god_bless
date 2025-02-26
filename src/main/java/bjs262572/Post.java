package bjs262572;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class Post {
    private final int id;
    private String title;
    private String content;
    private String author;
    private final List<Comment> comments = new ArrayList<>();

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                '}';
    }
}
