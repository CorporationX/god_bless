package leave.comments;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class PostService {
    private volatile List<Post> posts = new ArrayList<>();

    public void addPost(Post post) {
        synchronized (posts) {
            if (Objects.isNull(post)) {
                log.error("Your post is null!");
                Thread.currentThread().interrupt();
                throw new IllegalArgumentException();
            }
            posts.add(post);
        }
    }

    public synchronized void addComment(int postId, Comment comment) {
        synchronized (posts) {
            if (Objects.isNull(comment)) {
                log.error("Your post is null!");
                Thread.currentThread().interrupt();
                throw new IllegalArgumentException();
            } else if (!posts.stream().anyMatch(post -> post.getId() == postId)) {
                log.error("Your post is not found or it doesn t exist!");
                Thread.currentThread().interrupt();
                throw new IllegalArgumentException();
            }
            posts.stream()
                    .filter(post -> post.getId() == postId)
                    .forEach(post -> post.getComments().add(comment));
        }
    }

    public void readAllPosts() {
        synchronized (posts) {
            posts.stream().forEach(System.out::println);
        }
    }

    public synchronized void removePost(int postId, Author author) {
        synchronized (posts) {
            if (Objects.isNull(author)) {
                log.error("Your author is null!");
                Thread.currentThread().interrupt();
                throw new IllegalArgumentException();
            }
            posts.removeIf(post -> post.getId() == postId && post.getAuthor().equals(author));
        }
    }

    public synchronized void removeComment(int postId, LocalDateTime time, Author author) {
        synchronized (posts) {
            if (Objects.isNull(author) || Objects.isNull(time)) {
                log.error("Your author or comment is null!");
                Thread.currentThread().interrupt();
                throw new IllegalArgumentException();
            }
            for (Post post : posts) {
                if (post.getId() == postId) {
                    post.getComments()
                            .removeIf(comment1 -> comment1.getTimestamp().equals(time)
                                    && comment1.getAuthor().equals(author));
                }
            }
        }
    }
}
