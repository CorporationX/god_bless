package task16;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Post {
    private Long id;
    private String heading;
    private String text;
    private List<Comment> comments;
    public void addComment(Comment comment){
        comments.add(comment);
    }
}