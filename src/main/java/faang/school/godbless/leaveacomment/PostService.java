package faang.school.godbless.leaveacomment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {
    private final List<Post> posts = new ArrayList<>();
    private final Lock lock = new ReentrantLock();

    public void addPost(Post post) {
        lock.lock();
        try {
            posts.add(post);
        } finally {
            lock.unlock();
        }
    }

    public void removePost(int postId, String author) {
        lock.lock();
        try {
            posts.removeIf(post -> post.getId() == postId && post.getAuthor().equals(author));
        } finally {
            lock.unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        lock.lock();
        try {
            Optional<Post> post = posts.stream().filter(p -> p.getId() == postId).findFirst();
            post.ifPresent(p -> p.addComment(comment));
        } finally {
            lock.unlock();
        }
    }

    public void removeComment(int postId, Comment comment, String author) {
        lock.lock();
        try {
            Optional<Post> post = posts.stream().filter(p -> p.getId() == postId).findFirst();
            post.ifPresent(p -> {
                if (comment.getAuthor().equals(author)) {
                    p.removeComment(comment);
                }
            });
        } finally {
            lock.unlock();
        }
    }

    public List<Post> getPosts() {
        lock.lock();
        try {
            return new ArrayList<>(posts);
        } finally {
            lock.unlock();
        }
    }
}