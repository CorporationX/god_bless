package faang.school.godbless.sprint2.comment;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Evgenii Malkov
 */
@Slf4j
public class PostService {

    @Getter
    private volatile List<Post> posts = new ArrayList<>();
    private final AtomicLong postCounter = new AtomicLong(0);
    private final Object lock = new Object();

    public void addComment(long postId, @NonNull Comment comment) {
        synchronized (lock) {
            findPostById(postId).ifPresentOrElse(
                    (post) -> post.addComment(comment),
                    () -> log.error("{} пост не найден", postId)
            );

        }
    }

    public void addPost(Post post) {
        synchronized (lock) {
            post.setId(postCounter.getAndIncrement());
            posts.add(post);
            log.info("Добавлен пост {} автор {}", post.getId(), post.getAuthor());
        }
    }

    public Post getPost(long id) {
        return posts.stream()
                .filter((post -> post.getId() == id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(id + " пост не найден"));
    }

    public void deletePost(String username, long id) {
        Optional<Post> removingPostOptional = findPostById(id);
        if (removingPostOptional.isPresent()) {
            Post removingPost = removingPostOptional.get();
            if (!removingPost.getAuthor().getUsername().equals(username)) {
                log.error("Удаление доступно только автору поста. {} {}", username, id);
                return;
            }
            synchronized (lock) {
                if (posts.remove(removingPost)) {
                    log.info("Пост {} успешно удален", removingPost.getId());
                } else {
                    log.error("Не удалось удалить пост {}", removingPost.getId());
                }
            }
        }
    }

    public void deleteComment(String username, long postId, long commentId) {
        Optional<Post> postOptional = findPostById(postId);
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            Comment comment = findCommentById(post, commentId);
            if (comment.getAuthor().getUsername().equals(username)) {
                log.error("Функция доступна только автору комментария");
                return;
            }
            synchronized (lock) {
                if (post.getComments().remove(comment)) {
                    log.info("Комментарий {} успешно удален из поста {}", comment.getId(), post.getId());
                } else {
                    log.error("Не удалось удалить комментарий {} из поста {}", comment.getId(), post.getId());
                }
            }
        }
    }

    private Optional<Post> findPostById(long id) {
        return posts.stream()
                .filter(p -> id == p.getId())
                .findFirst();
    }

    private Comment findCommentById(Post post, long id) {
        return post.getComments()
                .stream()
                .filter((comment -> comment.getId() == id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(
                        String.format("Комментарий с id %s не найден в посте %s", post.getId(), id)));
    }
}
