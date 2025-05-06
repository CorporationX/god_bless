package school.faang.leave_comment;

import java.util.List;

public record Post(int id, String title, String content, List<Comment> comments) {
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
    }
}
