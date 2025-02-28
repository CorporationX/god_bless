package school.faang.task_62690;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {
    private final List<Post> posts = new ArrayList<>();
    private final ReentrantLock lock = new ReentrantLock();

    public void addPost(Post post) {
        lock.lock();
        try {
            posts.add(post);
        } finally {
            lock.unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        lock.lock();
        try {
            Post post = posts.get(postId);
            post.getComments().add(comment);
        } finally {
            lock.unlock();
        }
    }

    public void deletePosts(int postId, String author) {
        lock.lock();
        try {
            posts.removeIf(post -> post.getId() == postId && post.getAuthor().equals(author));
        } finally {
            lock.unlock();
        }
    }

    public void deleteComment(int postId, String author, LocalDateTime timestamp) {
        lock.lock();
        try {
            for (Post post : posts) {
                if (post.getId() == postId) {
                    post.getComments().removeIf(postComment -> postComment.getAuthor()
                            .equals(author) && postComment.getTimestamp().equals(timestamp));
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public List<Post> getPosts(String author) {
        lock.lock();
        try {
            return posts.stream()
                    .filter(post -> post.getAuthor().equals(author))
                    .toList();
        } finally {
            lock.unlock();
        }
    }

    public List<Comment> getComments(Post post) {
        lock.lock();
        try {
            return posts.stream()
                    .filter(p -> p.getId() == post.getId())
                    .flatMap(post1 -> post1.getComments().stream())
                    .toList();

        } finally {
            lock.unlock();
        }
    }

}
