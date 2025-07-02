package school.faang.bjs2_83012;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@Getter
public class PostService {
    private static final int MAX_PRINT_COMMENT = 3;
    private static final int COMMENT_PREVIEW_LENGTH = 100;

    private final ReentrantLock commentLock = new ReentrantLock();
    private final ReentrantLock postsLock = new ReentrantLock();

    private final List<Post> posts;

    public PostService(@NonNull List<Post> posts) {
        this.posts = posts;
    }

    public void addPost(Post post) {
        postsLock.lock();
        try {
            posts.add(post);
            log.info("Добавлен пост \"{}\"", post.getTitle());
        } finally {
            postsLock.unlock();
        }
    }

    public void addComment(long postId, Comment comment) {
        Optional<Post> foundPost = findById(postId);
        postsLock.lock();
        try {
            foundPost.ifPresentOrElse(
                    post -> post.addComment(comment),
                    () -> printObjectNotFound(postId)
            );
        } finally {
            postsLock.unlock();
        }
    }

    public List<Post> getPostsByAuthor(long userId) {
        return posts.stream()
                .filter(post -> post.getAuthor().getId() == userId)
                .toList();
    }

    public void printPostAndComments(long postId) {
        Optional<Post> foundPost = findById(postId);
        postsLock.lock();
        try {
            foundPost.ifPresentOrElse(
                    post -> {
                        List<Comment> comments = post.getComments();
                        int commentsToPrint = Math.min(MAX_PRINT_COMMENT, comments.size());
                        for (int i = 0; i < commentsToPrint; i++) {
                            String commentText = comments.get(i).getText();
                            String preview = commentText.length() <= COMMENT_PREVIEW_LENGTH
                                    ? commentText
                                    : commentText.substring(0, COMMENT_PREVIEW_LENGTH) + "...";
                            log.info(preview);
                        }
                    },
                    () -> printObjectNotFound(postId)
            );
        } finally {
            postsLock.unlock();
        }
    }

    public void removePost(long postId) {
        postsLock.lock();
        try {
            boolean removedPost = posts.removeIf(post -> post.getId() == postId);
            if (!removedPost) {
                printObjectNotFound(postId);
                return;
            }
            log.info("Был удален пост c id={}", postId);
        } finally {
            postsLock.unlock();
        }
    }

    public boolean isEmptyPosts() {
        return posts.isEmpty();
    }

    private void printObjectNotFound(long id) {
        log.info("Объект с id={} не был найден", id);
    }

    private Optional<Post> findById(long postId) {
        return posts.stream()
                .filter(post -> post.getId() == postId)
                .findFirst();
    }
}
