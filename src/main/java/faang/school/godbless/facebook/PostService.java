package faang.school.godbless.facebook;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {

    private final Lock lock = new ReentrantLock();
    private volatile List<Post> posts = new ArrayList<>();

    public void addComment(@NonNull Post post, @NonNull Comment comment) {
        lock.lock();
        try {
            posts.stream().filter(post1 -> post1.getId() == post.getId()).findFirst().ifPresent(post1 -> post1.addComment(comment));
        } finally {
            lock.unlock();
        }
    }

    public void removeComment(@NonNull Post post, @NonNull Comment comment, @NonNull String userName) {
        lock.lock();
        try {
            posts.stream().filter(post1 -> post1.getId() == post.getId()).findFirst().ifPresent(post1 -> post1.removeComment(comment, userName));
        } finally {
            lock.unlock();
        }
    }

    public void addPost(@NonNull Post post) {
        lock.lock();
        try {
            posts.add(post);
        } finally {
            lock.unlock();
        }
    }

    public void removePost(@NonNull Post post, @NonNull String user) {
        lock.lock();
        try {
            posts.stream().filter(post1 -> post1.getId() == post.getId()).findFirst().ifPresent(post1 -> {
                if (post1.getAuthor().equals(user)) {
                    posts.remove(post);
                }
            });
        } finally {
            lock.unlock();
        }
    }

    public void printPosts() {
        if (posts.isEmpty()) {
            return;
        }
        lock.lock();
        try {
            posts.forEach(post -> System.out.println("Post id: " + post.getId() + ", his author: " + post.getAuthor() + ", his comments: " + post.getComments()));
        } finally {
            lock.unlock();
        }

    }

}
