package school.faang.sprint4.bjs2_62623;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class PostService {
    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    public void addPost(Post post) {
        posts.put(post.getId(), post);
    }

    public void addComment(int postId, Comment comment) {
        Post post = posts.get(postId);
        if (post != null) {
            synchronized (post) {
                post.getComments().add(comment);
            }
        }
    }

    public boolean deletePost(int postId, String user) {
        Post post = posts.get(postId);
        if (post != null && post.getAuthor().equals(user)) {
            posts.remove(postId);
            log.info("Пост '{}' успешно удален пользователем '{}'", postId, user);
            return true;
        } else if (post == null) {
            log.warn("Попытка удалить несуществующий пост пользователем '{}'", user);
        } else {
            log.warn("Пользователь {} попытался удалить не свой пост '{}'", user, postId);
        }
        return false;
    }

    public boolean deleteComment(int postId, int commentIndex, String user) {
        Post post = posts.get(postId);
        if (post != null) {
            synchronized (post) {
                List<Comment> comments = post.getComments();
                if (commentIndex >= 0 && commentIndex < comments.size()) {
                    Comment comment = comments.get(commentIndex);
                    if (comment.getAuthor().equals(user)) {
                        comments.remove(commentIndex);
                        log.info("Комментарий {} успешно удален пользователем {}", commentIndex, user);
                        return true;
                    } else {
                        log.warn("Пользователь {} попытался удалить не свой комментарий '{}'", user, commentIndex);
                    }
                } else {
                    log.warn("Попытка удалить несуществующий комментарий пользователем '{}'", user);
                }
            }
        } else {
            log.warn("Попытка удалить комментарий на несуществующем посте пользователем '{}'", user);
        }
        return false;
    }

    public Post getPost(int postId) {
        return posts.get(postId);
    }
}
