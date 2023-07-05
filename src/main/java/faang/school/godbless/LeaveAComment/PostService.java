package faang.school.godbless.LeaveAComment;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Data
@AllArgsConstructor
public class PostService {
    private volatile List<Post> posts;
    private final ReentrantLock lock = new ReentrantLock();

    public synchronized void addComment(int postId, Comment comment) {
        lock.lock();
        if (posts.stream().map(Post::getId).anyMatch(id -> id == postId)) {
            System.out.print(Thread.currentThread().getId() + "| ");
            posts.stream()
                    .filter(post -> post.getId() == postId)
                    .findFirst()
                    .orElseThrow()
                    .addComment(comment);
            System.out.printf("Comment with id %s was added to post with id %s\n", comment.getId(), postId);
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        lock.unlock();
    }

    public synchronized void addPost(Post post) {
        lock.lock();
        System.out.print(Thread.currentThread().getId() + "| ");
        posts.add(post);
        System.out.printf("Post with id %s was added\n", post.getId());
        notify();
        lock.unlock();
    }

    public synchronized Comment findCommentById(int id) {
        if (lock.isLocked() || posts.stream()
                .flatMap(post -> post.getCommentList().stream()).
                noneMatch(comment -> comment.getId() == id)) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return posts.stream()
                .flatMap(post -> post.getCommentList()
                        .stream())
                .filter(comment -> comment.getId() == id)
                .findFirst()
                .orElseThrow();
    }

    public synchronized Post findPostById(int id) {
        if (lock.isLocked() || posts.stream().noneMatch(post -> post.getId() == id)) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return posts.stream()
                .filter(post -> post.getId() == id)
                .findFirst()
                .orElseThrow();
    }

    public synchronized void deletePost(int id) {
        lock.lock();
        if (posts.stream().noneMatch(post -> post.getId() == id)) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        posts.removeIf(post -> post.getId() == id);
        System.out.printf("Post with id %s was deleted\n", id);
        lock.unlock();
    }

    public synchronized void deleteComment(int id) {
        lock.lock();
        if (posts.stream()
                .flatMap(post -> post.getCommentList().stream()).
                noneMatch(comment -> comment.getId() == id)) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        posts.forEach(post -> post.getCommentList()
                .removeIf(comment -> comment.getId() == id));
        System.out.printf("Comment with id %s was deleted\n", id);
        lock.unlock();
    }
}
