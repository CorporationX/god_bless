package school.faang.sprint4.bjs2_62623;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {
    private final Map<Integer, Post> posts = new HashMap<>();
    private final Lock lock = new ReentrantLock();

    public void addPost(Post post) {
        lock.lock();
        try {
            posts.put(post.getId(), post);
        } finally {
            lock.unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        lock.lock();
        try {
            Post post = posts.get(postId);
            if (post != null) {
                post.getComments().add(comment);
            }
        } finally {
            lock.unlock();
        }
    }

    public boolean deletePost(int postId, String user) {
        lock.lock();
        try {
            Post post = posts.get(postId);
            if (post != null && post.getAuthor().equals(user)) {
                posts.remove(postId);
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public boolean deleteComment(int postId, int commentIndex, String user) {
        lock.lock();
        try {
            Post post = posts.get(postId);
            if (post != null) {
                List<Comment> comments = post.getComments();
                if (commentIndex >= 0 && commentIndex < comments.size()) {
                    Comment comment = comments.get(commentIndex);
                    if (comment.getAuthor().equals(user)) {
                        comments.remove(commentIndex);
                        return true;
                    }
                }
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public Post getPost(int postId) {
        return posts.get(postId);
    }
}
