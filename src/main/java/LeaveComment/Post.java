package LeaveComment;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter

public class Post {
    private final int ID;
    private String author;
    private String title;
    private String text;
    private static final List<Comment> commentList = new ArrayList<>();

    public void addComment(Comment comment) {
        commentList.add(comment);
        System.out.println("Comment added " + comment.getComment());
    }

    public void deleteComment(Comment comment) {
        commentList.remove(comment);
        System.out.println("Коментарий был удален");
    }

    public void print() {
        commentList.forEach(comment -> System.out.println(comment.getComment()));
    }
}