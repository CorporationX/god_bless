package faang.school.godbless.LeaveAComment;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Post {
    private int id;
    private String title;
    private String text;
    private String author;
    private List<Comment> commentList;

    public void addComment(Comment comment) {
        commentList.add(comment);
    }
}
