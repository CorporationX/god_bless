package school.faang.sprint_4.task_51093;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {
    private final Map<Integer, Post> posts = new HashMap<>();
    private final Lock lock = new ReentrantLock();

    public void addPost(@NonNull Post post) {
        lock.lock();
        try {
            posts.put(post.getId(), post);
        } finally {
            lock.unlock();
        }
    }

    public void addComment(int postId, @NonNull Comment comment) {
        lock.lock();
        try {
            posts.get(postId)
                    .addComment(comment);
        } finally {
            lock.unlock();
        }
    }

    public Optional<Post> getPostById(int postId) {
        return Optional.ofNullable(posts.get(postId));
    }

    public Map<Integer, Post> getPosts() {
        return Map.copyOf(posts);
    }

    public void removePost(int postId, @NonNull String author) {
        lock.lock();

        try {
            Post post = posts.get(postId);
            if (post.getAuthor().equals(author)) {
                posts.remove(postId);
            } else {
                System.out.println(author + " doesn't have permission to delete this post");
            }
        } finally {
            lock.unlock();
        }
    }
}
