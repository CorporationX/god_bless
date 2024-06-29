package LeaveComment;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Getter
public class User {
    private String name;
    private static final List<Post> postUser = new ArrayList<>();
    private static final List<Comment> commentUser = new ArrayList<>();

    public static void addedPost(Post post) {
        postUser.add(post);
    }

    public static void addedComment(Comment comment) {
        commentUser.add(comment);
    }
}
