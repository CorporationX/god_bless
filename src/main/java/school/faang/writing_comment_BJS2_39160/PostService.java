package school.faang.writing_comment_BJS2_39160;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

@Getter
public class PostService {
    private volatile Map<Integer, Post> posts = new HashMap<>();
    private final ReentrantLock lock = new ReentrantLock();

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
            posts.get(postId).getComments().add(comment);
        } finally {
            lock.unlock();
        }
    }

    public void showPost(Post post) {
        int postId = post.getId();
        lock.lock();
        try {
            System.out.println(posts.get(postId));
        } finally {
            lock.unlock();
        }
    }

    public void deletePost(Post post, String user) {
        int postId = post.getId();
        lock.lock();
        try {
            if (posts.get(postId).getAuthor().equals(user)) {
                posts.remove(postId);
            } else {
                System.out.println("You are not allowed to delete this post");
            }
        } finally {
            lock.unlock();
        }
    }

    public void showComment(Post post, Comment comment) {
        int postId = post.getId();
        lock.lock();
        try {
            int commentIndex = posts.get(postId).getComments().indexOf(comment);
            System.out.println(posts.get(postId).getComments().get(commentIndex));
        } finally {
            lock.unlock();
        }
    }

    public void deleteComment(Post post, Comment comment, String user) {
        int postId = post.getId();
        lock.lock();
        try {
            int commentIndex = posts.get(postId).getComments().indexOf(comment);
            if (posts.get(postId).getComments().get(commentIndex).getAuthor().equals(user)) {
                posts.get(postId).getComments().remove(comment);
            } else {
                System.out.println("You are not allowed to delete this comment");
            }
        } finally {
            lock.unlock();
        }
    }
}