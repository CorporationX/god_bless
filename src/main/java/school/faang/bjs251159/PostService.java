package school.faang.bjs251159;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class PostService {

    private final List<Post> posts = new CopyOnWriteArrayList<>();

    private final Lock lock = new ReentrantLock();

    public void addPost(Post post) {
        lock.lock();
        try {
            posts.add(post);
            log.info("The post with id {} has added", post.getId());
        } finally {
            lock.unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        lock.lock();
        try {
            posts.get(postId).getComments().add(comment);
            log.info("The comment from author {} has added", comment.author());
        } finally {
            lock.unlock();
        }
    }

    public void printPosts() {
        lock.lock();
        try {
            posts.forEach(post -> {
                log.info("Post: {}, {}, {}", post.getAuthor(), post.getTitle(), post.getContent());
                post.getComments().forEach(comment ->
                        log.info("Comment: {}, {}, {}", comment.author(), comment.text(), comment.timestamp())
                );
            });
        } finally {
            lock.unlock();
        }
    }

    public void deletePost(int postId, String author) {
        lock.lock();
        try {
            posts.removeIf(post -> post.getId() == postId && post.getAuthor().equals(author));
            log.info("The post with id {} has deleted", postId);
        } finally {
            lock.unlock();
        }
    }

    public void deleteComment(int postId, LocalDateTime timestamp, String author) {
        lock.lock();
        try {
            for (Post post : posts) {
                if (post.getId() == postId) {
                    post.getComments().removeIf(comment ->
                            comment.timestamp().equals(timestamp) && comment.author().equals(author));
                    log.info("The comment in post with id {} from author {} has deleted", postId, author);
                }
            }
        } finally {
            lock.unlock();
        }
    }
}