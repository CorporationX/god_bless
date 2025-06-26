package school.faang.bjs2_83016;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    public boolean addComment(int postId, Comment comment) {
        lock.lock();
        try {
            Optional<Post> optionalPost = posts.stream()
                    .filter(p -> p.getId() == postId)
                    .findFirst();

            if (optionalPost.isEmpty()) {
                return false; // Пост не найден
            }

            Post post = optionalPost.get();
            synchronized (post) {
                post.getComments().add(comment);
            }
            return true;
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

    public boolean deletePost(int postId, String author) {
        lock.lock();
        try {
            return posts.removeIf(post -> post.getId() == postId && post.getAuthor().equals(author));
        } finally {
            lock.unlock();
        }
    }

    public List<Comment> getComments(int postId) {
        lock.lock();
        try {
            Optional<Post> optionalPost = posts.stream()
                    .filter(p -> p.getId() == postId)
                    .findFirst();

            if (optionalPost.isEmpty()) {
                return List.of();
            }

            Post post = optionalPost.get();
            synchronized (post) {
                return new ArrayList<>(post.getComments());
            }
        } finally {
            lock.unlock();
        }
    }

    public boolean deleteComment(int postId, Comment commentToDelete, String author) {
        lock.lock();
        try {
            Optional<Post> optionalPost = posts.stream()
                    .filter(p -> p.getId() == postId)
                    .findFirst();

            if (optionalPost.isEmpty()) {
                return false;
            }

            Post post = optionalPost.get();
            synchronized (post) {
                return post.getComments().removeIf(comment ->
                        comment.equals(commentToDelete) && comment.getAuthor().equals(author));
            }
        } finally {
            lock.unlock();
        }
    }
}
