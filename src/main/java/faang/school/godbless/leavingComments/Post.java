package faang.school.godbless.leavingComments;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Post {
    private int id;
    private String content;
    private String authorName;
    private List<Comment> comments = new ArrayList<>();

    public Post(int id, String content, String authorName) {
        this.id = id;
        this.content = content;
        this.authorName = authorName;
    }
}
