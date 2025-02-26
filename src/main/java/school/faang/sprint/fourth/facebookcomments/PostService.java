package school.faang.sprint.fourth.facebookcomments;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class PostService {
    private volatile List<Post> posts = new ArrayList<>();
    private final Lock lock = new ReentrantLock();

    public void addPost(@NonNull Post post) {
        lock.lock();
        try {
            posts.add(post);
        } finally {
            lock.unlock();
        }
    }

    public void addComment(int postId, @NonNull Comment comment) {
        lock.lock();
        try {
            posts.stream()
                    .filter(post -> post.getId() == postId)
                    .findFirst()
                    .ifPresent(post -> post.addComment(comment));
        } finally {
            lock.unlock();
        }
    }

    public Optional<Post> findPost(int postId) {
        return posts.stream()
                .filter(post -> post.getId() == postId)
                .findFirst();
    }

    public List<Comment> getComments(int postId) {
        return posts.stream()
                .filter(post -> post.getId() == postId)
                .findFirst()
                .map(Post::getComments)
                .orElse(new ArrayList<>());
    }

    public void removePost(int postId) {
        lock.lock();
        try {
            posts.stream().filter(post -> post.getId() == postId)
                    .findFirst()
                    .ifPresent(post -> posts.remove(post));
        } finally {
            lock.unlock();
        }
    }

    public void removeComment(int postId, @NonNull Comment comment) {
        lock.lock();
        try {
            posts.stream().filter(post -> post.getId() == postId)
                    .findFirst()
                    .ifPresent(post -> post.getComments().remove(comment));
        } finally {
            lock.unlock();
        }
    }
}
