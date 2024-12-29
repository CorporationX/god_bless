package school.faang.bjs251233;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {

    private List<Post> posts = new ArrayList<>();
    private Lock lock = new ReentrantLock();

    public void addPost(Post post) {
        lock.lock();
        try {
            posts.add(post);
            System.out.println("Post added: " + post.getTitle());
        } finally {
            lock.unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        lock.lock();
        try {
            findPostById(postId).ifPresentOrElse(
                    post -> {
                        post.getComments().add(comment);
                        System.out.println("Comment added to post: " + post.getTitle());
                    }, () -> {
                        throw new IllegalArgumentException("Post not found with ID: " + postId);
                    });
        } finally {
            lock.unlock();
        }
    }

    public void deletePost(int postId, String author) {
        lock.lock();
        try {
            findPostById(postId).ifPresent(post -> {
                if (post.getAuthor().equals(author)) {
                    posts.remove(post);
                    System.out.println("Post deleted: " + post.getTitle());
                } else {
                    System.out.println("Unauthorized attempt to delete post by: " + author);
                }
            });
        } finally {
            lock.unlock();
        }
    }

    public void deleteComment(int postId, LocalDateTime timestamp, String author) {
        lock.lock();
        try {
            findPostById(postId).ifPresent(post -> {
                boolean removed = post.getComments().removeIf(
                        el -> el.getAuthor().equals(author) && el.getTimestamp().equals(timestamp)
                );
                if (removed) {
                    System.out.println("Comment deleted from post: " + post.getTitle());
                }
            });
        } finally {
            lock.unlock();
        }
    }

    private Optional<Post> findPostById(int postId) {
        return posts.stream()
                .filter(post -> post.getId() == postId)
                .findFirst();
    }

}
