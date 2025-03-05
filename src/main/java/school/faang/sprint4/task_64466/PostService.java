package school.faang.sprint4.task_64466;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

@AllArgsConstructor
@Slf4j
public class PostService {
    private static final String POST_FORM = "Post with id {} {} post service.";
    private static final String commentAddForm = "{} {} post {}.";

    private final ExecutorService executor;
    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    public void addPost(Post post) {
        CompletableFuture.runAsync(() -> {
            if (!posts.containsKey(post.id())) {
                posts.put(post.id(), post);
                log.info(POST_FORM, post.id(), "added to");
            } else {
                log.warn(POST_FORM, post.id(), "is already added to");
            }
        }, executor);
    }

    public void removePost(Post post) {
        CompletableFuture.runAsync(() -> {
            if (posts.containsKey(post.id())) {
                posts.remove(post.id());
                log.info(POST_FORM, post.id(), "remove from");
            } else {
                log.warn(POST_FORM, post.id(), "does not exist in");
            }
        }, executor);
    }

    public CompletableFuture<Void> addComment(int postId, Comment comment) {
        return CompletableFuture.runAsync(() -> {
            if (!posts.containsKey(postId)) {
                return;
            }
            posts.get(postId).comments().add(comment);
            log.info(commentAddForm, comment.text(), "add to", postId);
        }, executor);
    }

    public CompletableFuture<Void> removeComment(int postId, Comment comment) {
        return CompletableFuture.runAsync(() -> {
            if (!posts.containsKey(postId)) {
                return;
            }

            posts.get(postId).comments().remove(comment);
            log.info(commentAddForm, comment.text(), "remove from", postId);
        }, executor);
    }

    public void printPosts() {
        posts.forEach((id, post) -> post.comments().forEach(comment -> log.debug("post_{} - {},", id, comment.text())));
    }
}
