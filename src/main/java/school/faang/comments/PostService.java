package school.faang.comments;

import java.util.*;
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
            posts.get(postId).getComments().add(comment);
        } finally {
            lock.unlock();
        }
    }

    public void showPost(int postId) {
        System.out.println(posts.get(postId));
    }

    public void showCommentsByPost(int postId) {
        System.out.println(posts.get(postId).getComments());
    }

    public Optional<Post> removePost(int postId, int authorId) {
        lock.lock();
        try {
            if (authorId == posts.get(postId).getAuthorId()) {
                return Optional.of(posts.remove(postId));
            } else {
                return Optional.empty();
            }
        } finally {
            lock.unlock();
        }
    }

    public Optional<Comment> removeCommentByAuthorId(int postId, int authorId, String commentText) {
        lock.lock();
        try {
            for (Comment comment : posts.get(postId).getComments()) {
                if (comment.getAuthor().getId() == authorId && comment.getText().equals(commentText)) {
                    posts.get(postId).getComments().remove(comment);
                    return Optional.of(comment);
                }
            }

            return Optional.empty();
        } finally {
            lock.unlock();
        }
    }
}
