package school.faang.task_51495;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {
    private final List<Post> posts = Collections.synchronizedList(new ArrayList<>());
    private final Lock lock = new ReentrantLock();

    public void addPost(Post post) {
        lock.lock();
        try {
            posts.add(post);
            System.out.println("Post added: " + post.getTitle());
        } finally {
            lock.unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        lock.lock();
        try {
            for (Post post : posts) {
                if (post.getId() == postId) {
                    post.addComment(comment);
                    System.out.println("Comment added to post " + postId + ": " + comment.getText());
                    return;
                }
            }
            System.out.println("Post with ID " + postId + " not found.");
        } finally {
            lock.unlock();
        }
    }

    public List<Post> getPosts() {
        return new ArrayList<>(posts);
    }

    public void removePost(int postId, String author) {
        lock.lock();
        try {
            posts.removeIf(post -> post.getId() == postId && post.getAuthor().equals(author));
            System.out.println("Post with ID " + postId + " removed by author " + author);
        } finally {
            lock.unlock();
        }
    }

    public void removeComment(int postId, String commentAuthor, String removingUser) {
        lock.lock();
        try {
            for (Post post : posts) {
                if (post.getId() == postId) {
                    post.getComments().removeIf(comment -> comment.getAuthor().equals(commentAuthor) && commentAuthor.equals(removingUser));
                    System.out.println("Comment removed by author " + removingUser);
                    return;
                }
            }
            System.out.println("Post with ID " + postId + " not found.");
        } finally {
            lock.unlock();
        }
    }
}