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
            if (posts.containsKey(postId)) {
                posts.get(postId).getComments().add(comment);
            } else {
                System.out.printf("Not found post with id %s \n", postId);
            }
        } finally {
            lock.unlock();
        }
    }

    public void showPost(int postId) {
        if (posts.containsKey(postId)) {
            System.out.println(posts.get(postId));
        } else {
            System.out.printf("Not found post with id %s \n", postId);
        }
    }

    public void showCommentsByPost(int postId) {
        if (posts.containsKey(postId)) {
            System.out.println(posts.get(postId).getComments());
        } else {
            System.out.printf("Not found post with id %s \n", postId);
        }
    }

    public Optional<Post> removePost(int postId, int authorId) {
        lock.lock();
        try {
            if (posts.containsKey(postId) && authorId == posts.get(postId).getAuthorId()) {
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
            if (posts.containsKey(postId)) {
                for (Comment comment : posts.get(postId).getComments()) {
                    if (comment.getAuthor().getId() == authorId && comment.getText().equals(commentText)) {
                        posts.get(postId).getComments().remove(comment);
                        return Optional.of(comment);
                    }
                }
            }

            return Optional.empty();
        } finally {
            lock.unlock();
        }
    }
}
