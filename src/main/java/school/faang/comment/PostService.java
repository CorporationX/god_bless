package school.faang.comment;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
public class PostService {

    private final List<Post> posts = new CopyOnWriteArrayList<>();

    public void addPost(@NonNull Post post) {
        posts.add(post);
        log.info("Добавлен новый пост с id: {}", post.getId());
    }

    public void addComment(int postId, @NonNull Comment comment) {
        posts.stream()
                .filter(post -> post.getId() == postId)
                .forEach(post -> post.addComment(comment));
        log.info("К посту №{} добавлен комментарий: {}", postId, comment.getText());
    }

    public void removePost(int postId, @NonNull String user) {
        Post currentPost = getPostById(postId);
        if (!currentPost.getAuthor().equals(user)) {
            log.warn("Пользователь {} пытается удалить чужой пост!", user);
            return;
        }
        posts.remove(currentPost);
        log.info("Пользователь {} удалил пост №{}", user, postId);
    }

    public List<Comment> getCommentsOfPost(int postId) {
        Post currentPost = getPostById(postId);
        return (currentPost != null) ? currentPost.getComments() : Collections.emptyList();
    }

    public void removeComment(int postId, @NonNull String commentAuthor, @NonNull LocalDateTime timestamp) {
        Post post = getPostById(postId);
        if (post != null) {
            post.removeComment(commentAuthor, timestamp);
            log.info("Комментарий пользователя {} удалён из поста {}", commentAuthor, postId);
        }
    }

    public Post getPostById(int postId) {
        return posts.stream()
                .filter(post -> post.getId() == postId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Пост с id " + postId + " не найден"));
    }
}
