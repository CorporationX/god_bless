package school.faang.bjs2_83012;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@Getter
@AllArgsConstructor
public class PostService {
    private static final int MAX_PRINT_COMMENT = 3;
    private final Object commentLock = new Object();
    private final Object postsLock = new Object();

    private List<Post> posts;

    public void addPost(Post post) {
        synchronized (postsLock) {
            posts.add(post);
            log.info("Добавлен пост \"{}\"", post.getTitle());
        }
    }

    public void addComment(long postId, Comment comment) {
        Optional<Post> foundPost = findById(postId);
        foundPost.ifPresentOrElse(
                post -> {
                    synchronized (commentLock) {
                        post.getComments().add(comment);
                        log.info("Добавлен комментарий в пост с title={}", post.getTitle());
                    }
                },
                () -> printObjectNotFound(postId)
        );
    }

    public List<Post> getPostsByAuthor(long userId) {
        return posts.stream()
                .filter(post -> post.getAuthor().getId() == userId)
                .toList();
    }

    public void printPostAndComments(long postId) {
        Optional<Post> foundPost = findById(postId);
        foundPost.ifPresentOrElse(
                post -> {
                    synchronized (commentLock) {
                        log.info("Пост | Название: {} | Содержание: {} | Автор: {}",
                                post.getTitle(), post.getContent(), post.getAuthor().getName()
                        );
                        for (int i = 0; i <= Math.min(MAX_PRINT_COMMENT, post.getComments().size()); i++) {
                            String commentText = post.getComments().get(i).getText();
                            int endIndex = Math.min(100, commentText.length());
                            log.info("{}...", commentText.substring(0, endIndex));
                        }
                    }
                },
                () -> printObjectNotFound(postId)
        );
    }

    public void removePost(long postId) {
        synchronized (postsLock) {
            boolean removedPost = posts.removeIf(post -> post.getId() == postId);
            if (!removedPost) {
                printObjectNotFound(postId);
                return;
            }
            log.info("Был удален пост c id={}", postId);
        }
    }

    public boolean isEmptyPosts() {
        return posts.isEmpty();
    }

    private void printObjectNotFound(long id) {
        log.info("Объект с id={} не был найден", id);
    }

    private Optional<Post> findById(long postId) {
        synchronized (postsLock) {
            return posts.stream()
                    .filter(post -> post.getId() == postId)
                    .findFirst();
        }
    }
}
