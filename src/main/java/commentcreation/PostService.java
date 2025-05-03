package commentcreation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {
    private final List<Post> posts = new CopyOnWriteArrayList<>();
    private final ReentrantLock lock = new ReentrantLock();
    private final AtomicInteger postIdCounter = new AtomicInteger(0);

    public void addPost(Post post) {
        lock.lock();
        try {
            posts.add(post);
            post.setId(postIdCounter.incrementAndGet());
        } finally {
            lock.unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        lock.lock();
        try {
            posts.get(postId).getComments().add(comment);
        } finally {
            lock.unlock();
        }
    }

    public List<Post> getAllPosts() {
        lock.lock();
        try {
            return new ArrayList<>(posts);
        } finally {
            lock.unlock();
        }
    }

    public List<Comment> getCommentsForPost(int postId) {
        lock.lock();
        try {
            return posts.stream()
                    .filter(p -> p.getId() == postId)
                    .findFirst()
                    .map(Post::getComments)
                    .orElse(List.of()); // Возвращаем пустой список, если пост не найден
        } finally {
            lock.unlock();
        }
    }

    public void deletePost(int postId, String author) {
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
            posts.get(postId).getComments()
                    .removeIf(comment -> comment.getAuthor().equals(author)
                            && comment.getTimestamp().equals(timestamp));
        } finally {
            lock.unlock();
        }
    }
}
