package school.faang.m1s4.bjs2_39276_postsComments;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class PostService {
    private static final int N_POOLS = 10;

    private final ExecutorService service = Executors.newFixedThreadPool(N_POOLS);

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    public void addPost(Post post) {
        CompletableFuture.runAsync(() -> {
            posts.put(post.getId(), post);
            log.info("{} added new post {}", post.getAuthor(), post.getTitle());
        }, service);
    }

    public void addComment(int postId, Comment comment) {
        CompletableFuture.runAsync(() -> {
            posts.get(postId).addComment(comment);
            log.info("Post {} {}: new comment by {}", postId, posts.get(postId).getTitle(), comment.getUserName());
        }, service);
    }

    public void showPosts() {
        CompletableFuture.runAsync(() ->
                posts.forEach((id, post) -> log.info(id + " : " + post)), service);
    }

    public void showComments(int idPost) {
        CompletableFuture.runAsync(() ->
                posts.get(idPost).getComments().forEach((id, comment) -> System.out.println(id + " : " + comment)), service);
    }

    public void removePost(int idPost, String authorName) {
        CompletableFuture.runAsync(() -> {
            if (isAuthorPost(idPost, authorName)) {
                log.info("Post #{} {} removed", idPost, posts.get(idPost).getTitle());
                posts.remove(idPost);
            } else {
                log.error("Invalid access by {}", authorName);
                throw new SecurityException("Removal forbidden: insufficient rights");
            }
        }, service);
    }

    public void removeComment(int idPost, int idComment, String authorName) {
        if (posts.containsKey(idPost)) {
            CompletableFuture.runAsync(() -> {
                if (isAuthorComment(idPost, idComment, authorName)) {
                    log.info("Comment by {} from post #{} {} was removed", authorName, idPost, posts.get(idPost).getTitle());
                    posts.get(idPost).getComments().remove(idComment);
                } else {
                    log.error("Invalid access by {}", authorName);
                    throw new RuntimeException("Removal forbidden: insufficient rights");
                }
            }, service);
        } else {
            log.error("The post doesn't exist or was removed");
            throw new RuntimeException("Invalid request");
        }
    }

    private boolean isAuthorPost(int idPost, String authorName) {
        return posts.get(idPost).getAuthor().equals(authorName);
    }

    private boolean isAuthorComment(int idPost, int idComment, String authorName) {
        return posts.get(idPost).getComments().get(idComment).getUserName().equals(authorName);
    }

    public void shutdownPool() {
        service.shutdown();
        try {
            if (!service.awaitTermination(30, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Thread has been terminated", e);
        }
    }
}
