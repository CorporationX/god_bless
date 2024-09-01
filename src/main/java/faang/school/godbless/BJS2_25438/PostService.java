package faang.school.godbless.BJS2_25438;

import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@RequiredArgsConstructor
public class PostService {
    private final Map<Long, Post> posts;
    private final Lock lock = new ReentrantLock();

    public void addComment(Long postId, Comment comment) {
        lock.lock();
        try {
            Post post = posts.get(postId);
            if (post == null) {
                throw new IllegalArgumentException("Post not found: " + postId);
            }
            post.comments().putIfAbsent(comment.id(), comment);
        } finally {
            lock.unlock();
        }
    }

    public void addPost(Post post) {
        lock.lock();
        try {
            posts.putIfAbsent(post.id(), post);
        } finally {
            lock.unlock();
        }
    }

    public void removePost(Long postId, Author author) {
        lock.lock();
        try {
            Post post = posts.get(postId);
            if (post == null) {
                throw new IllegalArgumentException("Post not found: " + postId);
            }
            if (post.author().equals(author)) {
                posts.remove(postId);
            }
        } finally {
            lock.unlock();
        }
    }

    public void removeComment(Long commentId, Long postId, Author author) {
        lock.lock();
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
            lock.unlock();
        }
    }

    public void showPosts() {
        lock.lock();
        try {
            for (Map.Entry<Long, Post> entry : posts.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } finally {
            lock.unlock();
        }
    }


}
