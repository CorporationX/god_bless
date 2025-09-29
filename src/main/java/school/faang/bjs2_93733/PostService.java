package school.faang.bjs2_93733;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Slf4j
@Getter
@Setter
public class PostService {
    private static final int SLEEPING_TIME = 3;
    private final Object postLock = new Object();
    private final Object commentLock = new Object();
    private volatile List<Post> posts = new ArrayList<>();

    public void addPost(@NonNull Post post) {
        synchronized (postLock) {
            try {
                log.info("Добавляем новый пост '{}'.", post.getId());
                TimeUnit.SECONDS.sleep(SLEEPING_TIME);
                log.info("Пост '{}' успешно добавлен.", post.getId());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.info("Пост '{}' не удалось добавить, он не прошел модерацию.", post.getId());
            }
            posts.add(post);
        }
    }

    public void addComment(int postId, @NonNull Comment comment) {
        synchronized (commentLock) {
            try {
                log.info("Добавляем комментарий  от {}.", comment.getAuthor());
                TimeUnit.SECONDS.sleep(SLEEPING_TIME);
                for (Post post : posts) {
                    if (post.getId() == postId) {
                        post.getComments().add(comment);
                        log.info("Успешно добавили комментарий от пользователя {} к посту {}.",
                                comment.getAuthor(), post.getTitle());
                        break;
                    }
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.info("Не удалось добавить комментарий от {}, он не прошел модерацию.", comment.getAuthor());
            }
        }
    }

    public void deletePost(@NonNull String userDeleterName, @NonNull Post post) {
        synchronized (postLock) {
            try {
                log.info("Начинаем удалять пост '{}'.", post.getId());
                TimeUnit.SECONDS.sleep(SLEEPING_TIME);
                if (Objects.equals(post.getAuthor(), userDeleterName)) {
                    posts.remove(post);
                } else {
                    log.info("Не удалось удалить пост '{}', вы - не автор.", post.getId());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.info("Не удалось завершить операцию по удалению поста '{}', поток был прерван.", post.getId());
            }
        }
    }

    public void deleteComment(@NonNull String userDeleterName, @NonNull Post post, @NonNull Comment comment) {
        synchronized (commentLock) {
            try {
                log.info("Начинаем удалять комментарий от автора {}", comment.getAuthor());
                TimeUnit.SECONDS.sleep(SLEEPING_TIME);
                for (Comment com : post.getComments()) {
                    if (com == comment) {
                        if (Objects.equals(com.getAuthor(), userDeleterName)) {
                            post.getComments().remove(comment);
                            log.info("Комментарий от пользователя {} удален.", com.getAuthor());
                        } else {
                            log.info("Только автор ({}) имеет право удалить этот комментарий.", comment.getAuthor());
                        }
                        break;
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.info("Не удалось удалить комментарий от автора {}, поток был прерван.", comment.getAuthor());
            }
        }
    }
}
