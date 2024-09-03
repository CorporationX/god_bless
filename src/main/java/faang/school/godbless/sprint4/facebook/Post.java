package faang.school.godbless.sprint4.facebook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@AllArgsConstructor
@Getter
@ToString
public class Post {
    private final long id;
    private String title;
    private User author;
    private final Map<Long, Comment> comments = new ConcurrentHashMap<>();

    public synchronized void addComment(Comment comment) {
        comments.put(comment.getId(), comment);
        System.out.printf("Комментарий с id %d успешно добавлен в пост с id %d%n", comment.getId(), id);

    }

    public synchronized void deleteComment(User user, long commentId) {
        if (isAvailableToDelete(user, commentId)) {
            comments.remove(commentId);
            System.out.printf("Комментарий с id %d успешно удален из поста %d%n", commentId, id);
        }
    }

    private boolean isAuthorOfCommentOrAuthorOfPost(User user, long commentId) {
        return user.equals(comments.get(commentId).getAuthor()) || user.equals(author);
    }

    private boolean isAvailableToDelete(User user, long commentId) {
        if (!comments.containsKey(commentId)) {
            System.out.printf("Комменарий с id %s не найден%n", commentId);
            return false;
        }
        if (!isAuthorOfCommentOrAuthorOfPost(user, commentId)) {
            System.out.printf("Пользователь %s не является автором этого поста или автором комментария с id %d%n", user, commentId);
            return false;
        }
        return true;
    }
}