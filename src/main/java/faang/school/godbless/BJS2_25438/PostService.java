package faang.school.godbless.BJS2_25438;

import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@RequiredArgsConstructor
public class PostService {
    private final Map<Long, Post> posts;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void addComment(Long postId, Comment comment) {
        lock.writeLock().lock();
        try {
            Post post = posts.get(postId);
            if (post == null) {
                throw new IllegalArgumentException("Post not found: " + postId);
            }
            post.comments().putIfAbsent(comment.id(), comment);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void addPost(Post post) {
        lock.writeLock().lock();
        try {
            posts.putIfAbsent(post.id(), post);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void removePost(Long postId, Author author) {
        lock.writeLock().lock();
        try {
            Post post = posts.get(postId);
            if (post == null) {
                throw new IllegalArgumentException("Post not found: " + postId);
            }
            if (post.author().equals(author)) {
                posts.remove(postId);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void removeComment(Long commentId, Long postId, Author author) {
        lock.writeLock().lock();
        try {
            Post post = posts.get(postId);
            if (post == null) {
                throw new IllegalArgumentException("Post not found: " + postId);
            }
            Comment comment = post.comments().get(commentId);
            if (comment == null) {
                throw new IllegalArgumentException("Comment not found: " + commentId);
            }

            if (comment.author().equals(author)) {
                posts.get(postId).comments().remove(commentId);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void showPosts() {
        lock.readLock().lock();
        try {
            for (Map.Entry<Long, Post> entry : posts.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } finally {
            lock.readLock().unlock();
        }
    }


}
