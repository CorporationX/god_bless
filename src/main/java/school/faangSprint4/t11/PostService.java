package school.faangSprint4.t11;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {
    private final List<Post> posts = new ArrayList<>();
    private final Lock lock = new ReentrantLock();

    public void addPost(Post post) {
        lock.lock();
        try {
            posts.add(post);
            System.out.println("Post added: " + post.getTitle() + " by " + post.getAuthor());
        } finally {
            lock.unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        lock.lock();
        try {
            for (Post post : posts) {
                if (post.getId() == postId) {
                    post.getComments().add(comment);
                    System.out.println("Comment added to post " + postId + " by " + comment.getAuthor());
                    return;
                }
            }
            System.out.println("Post not found: " + postId);
        } finally {
            lock.unlock();
        }
    }

    public boolean deletePost(int postId, String author) {
        lock.lock();
        try {
            return posts.removeIf(post ->
                    post.getId() == postId && post.getAuthor().equals(author));
        } finally {
            lock.unlock();
        }
    }

    public boolean deleteComment(int postId, LocalDateTime timestamp, String author) {
        lock.lock();
        try {
            for (Post post : posts) {
                if (post.getId() == postId) {
                    return post.getComments().removeIf(comment ->
                            comment.getTimestamp().equals(timestamp) &&
                                    comment.getAuthor().equals(author));
                }
            }
            return false;
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

    public List<Comment> getPostComments(int postId) {
        lock.lock();
        try {
            for (Post post : posts) {
                if (post.getId() == postId) {
                    return new ArrayList<>(post.getComments());
                }
            }
            return new ArrayList<>();
        } finally {
            lock.unlock();
        }
    }
}