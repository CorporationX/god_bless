package school.faang.stream4.facebookleavingacomment;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class PostService {
    @Getter
    private final ConcurrentHashMap<Integer, Post> posts = new ConcurrentHashMap<>();
    private final Lock lock = new ReentrantLock();

    public CompletableFuture<Void> addPost(Post post) {
        return CompletableFuture.runAsync(() -> posts.put(post.getId(), post));
    }

    public CompletableFuture<Void> addComment(int postId, Comment comment) {
        return CompletableFuture.runAsync(() -> {
            lock.lock();
            try {
                posts.get(postId).addComment(comment);
            } catch (NullPointerException e) {
                log.error("Такого поста не существует", e);
            } finally {
                lock.unlock();
            }
        });
    }

    public CompletableFuture<List<Post>> showPostsOfThisAuthor(String author) {
        return CompletableFuture.supplyAsync(() -> {
            ConcurrentHashMap<Integer, Post> postsCopy = this.getPosts();
            return postsCopy.values().stream()
                    .filter(post -> Objects.equals(post.getAuthor(), author))
                    .toList();
        });
    }

    public CompletableFuture<List<Comment>> showCommentsToPostByPostId(int postId) {
        return CompletableFuture.supplyAsync(() -> {
            lock.lock();
            try {
                return posts.get(postId).getComments();
            } catch (NullPointerException e) {
                log.error("Такого поста не существует", e);
                return Collections.emptyList();
            } finally {
                lock.unlock();
            }
        });
    }

    public CompletableFuture<Void> removePostByPostIdByItsAuthor(int postId, String author) {
        return CompletableFuture.runAsync(() -> {
            Post post = posts.get(postId);
            if (post != null && Objects.equals(post.getAuthor(), author)) {
                posts.remove(postId);
            }
        });
    }

    public CompletableFuture<Void> removeCommentByItsAuthorByTimeStamp(int postId,
                                                                       String author, LocalDateTime timeStamp) {
        return CompletableFuture.runAsync(() -> {
            lock.lock();
            try {
                Post post = posts.get(postId);
                if (post != null) {
                    List<Comment> comments = post.getComments();
                    comments.removeIf(comment ->
                            Objects.equals(comment.getAuthor(), author)
                                    && comment.getTimeStamp().equals(timeStamp)
                    );
                }
            } finally {
                lock.unlock();
            }
        });
    }
}
