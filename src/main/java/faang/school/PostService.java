package faang.school;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class PostService {
    private final List<Post> posts = new ArrayList<>();
    private final Lock lock = new ReentrantLock();

    public void addComment(Comment comment, int id) {
        lock.lock();
        posts.stream()
                .filter(post -> post.getId() == id)
                .findFirst()
                .ifPresentOrElse(
                        post -> {
                            post.addComment(comment);
                            System.out.println("Comment was added");
                        },
                        () -> System.out.println("No post with id: " + id)
                );
        lock.unlock();
    }

    public synchronized void addPost(Post post) {
        lock.lock();
        posts.add(post);
        lock.unlock();
    }

    public synchronized void addPost(Post[] postsList) {
        lock.lock();
        posts.addAll(Arrays.asList(postsList));
        lock.unlock();
    }

    public List<Post> getPosts() {
        return new ArrayList<>(posts);
    }
}
