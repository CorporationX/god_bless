package faang.school.godbless.multithreading.leave_comment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {
    private volatile List<Post> posts;
    private final Lock lock;

    public PostService() {
        posts = new ArrayList<>();
        lock = new ReentrantLock();
    }

    public void addComment(Comment comment, int postId) {
        lock.lock();
        posts.stream()
                .filter(p -> p.getId() == postId)
                .findFirst()
                .ifPresentOrElse(
                        p -> {
                            p.getComments().add(comment);
                            System.out.printf("%s was added to the post with id-%d by %s\n",
                                    comment, postId, Thread.currentThread().getName());
                            },
                        () -> System.out.printf("Post with id-%d was not found\n", postId)
                );
        lock.unlock();
    }

    public void addPost(Post post) {
        lock.lock();
        posts.add(post);
        System.out.printf("Post with id-%d was added by %s\n",
                post.getId(), Thread.currentThread().getName());
        lock.unlock();
    }

    public void removePost(Author author, int postId) {
        lock.lock();
        posts.removeIf(p -> p.getAuthor().equals(author) && p.getId() == postId);
        System.out.printf("%s has removed post with id-%d\n",
                Thread.currentThread().getName(), postId);
        lock.unlock();
    }

    public void removeComment(Author author, int commentId) {
        lock.lock();
        posts.forEach(p -> p.getComments().removeIf(c -> c.getId() == commentId && c.getAuthor().equals(author)));
        System.out.printf("%s has removed comment with id-%d\n",
                Thread.currentThread().getName(), commentId);
        lock.unlock();
    }

    public List<Post> getPosts() {
        return posts;
    }
}
