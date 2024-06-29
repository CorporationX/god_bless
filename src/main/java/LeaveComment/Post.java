package LeaveComment;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Post {
    private final int ID;
    private String author;
    private String title;
    private String text;
    private final List<Comment> commentList = new ArrayList<>();

    public void addComment(Comment comment) {
        commentList.add(comment);
        System.out.println("Comment add " + comment.getComment());
    }

    public void deleteComment(Comment comment) {
        commentList.remove(comment);
        System.out.println("Comment has been deleted");
    }

    public void print() {
        commentList.forEach(System.out::println);
    }
}