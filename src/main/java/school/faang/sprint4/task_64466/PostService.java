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
    private static final String postAddForm = "Post with id {} {} to post service.";
    private static final String commentAddForm = "{}{} add to post {}.";

    private final ExecutorService executor;
    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    public void addPost(Post post) {
        CompletableFuture.runAsync(() -> {
            if (!posts.containsKey(post.id())) {
                posts.put(post.id(), post);
                log.info(postAddForm, post.id(), "added");
            } else {
                log.warn(postAddForm, post.id(), "is already added");
            }
        }, executor);
    }

    public CompletableFuture<Void> addComment(int postId, Comment comment) {
        return CompletableFuture.runAsync(() -> {
            log.info(commentAddForm, comment.text(), " try to", postId);
            posts.get(postId).comments().add(comment);
            log.info(commentAddForm, comment.text(), "", postId);
        }, executor);
    }

    public void printPosts() {
        posts.forEach((id, post) -> {
            System.out.printf("post_%d -", id);
            post.comments().forEach(comment -> System.out.printf(" %s,", comment.text()));
            System.out.println("\b.");
        });
    }
}
