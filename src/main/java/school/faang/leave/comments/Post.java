package school.faang.leave.comments;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;

@Getter
@AllArgsConstructor
public class Post {
    private int id;
    private String title;
    private String content;
    private String author;
    private final ConcurrentMap<Integer, Comment> comments = new ConcurrentSkipListMap<>();

    public void addComment(Comment comment) {
        comments.put(comment.id(), comment);
    }

    public List<Comment> getComments() {
        return comments.values().stream().toList();
    }

    public void removeComment(int commentId, String initiator) {
        Comment comment = comments.get(commentId);
        validateComment(initiator, comment);
        comments.remove(commentId);
    }

    public boolean isPostAuthor(String user) {
        return author.equals(user);
    }

    public boolean containsContent(String content) {
        if (content == null) return false;
        return content.contains(this.content);
    }

    private void validateComment(String initiator, Comment comment) {
        if (comment == null) {
            throw new IllegalArgumentException("Данный комментарий не существует");
        }
        if (!comment.isCommentAuthor(initiator) && !this.isPostAuthor(initiator)) {
            throw new IllegalArgumentException("Пользователь не является автором комментария или поста");
        }
    }

    @Override
    public String toString() {
        return title + ": " + author;
    }
}
