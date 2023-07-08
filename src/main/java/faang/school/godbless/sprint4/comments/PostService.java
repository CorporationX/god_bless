package faang.school.godbless.sprint4.comments;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class PostService {
    private final Lock lock = new ReentrantLock();
    private volatile List<Post> posts = new ArrayList<>();

    public void addComment(int id, Comment comment) {
        lock.lock();
        try {
            Post post = findPostById(id);
            if (post != null) {
                post.addComments(comment);
            }
        } finally {
            lock.unlock();
        }
    }

    public void addPost(Post post) {
        lock.lock();
        try {
            posts.add(post);
        } finally {
            lock.unlock();
        }
    }

    public void deleteComment(int id, String author) {
        lock.lock();
        try {
            Post post = findPostById(id);
            if (post != null || post.getAuthor().equals(author)) {
                post.deleteComment(author);
            }
        } finally {
            lock.unlock();
        }
    }

    private Post findPostById(int postId) {
        for (Post post : posts) {
            if (post.getId() == postId) {
                return post;
            }
        }
        return null;
    }
}
