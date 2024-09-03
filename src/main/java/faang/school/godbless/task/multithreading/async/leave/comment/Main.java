package faang.school.godbless.task.multithreading.async.leave.comment;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int DEFAULT_POST_ID = 1;

    private static final Configuration config = new Configuration();
    private static final PostService postService = new PostService();
    private static final List<User> users = config.getUsers();
    private static final List<Post> posts = config.getPosts();
    private static final List<Comment> comments = config.getComments();
    private static final Post defaullPost = config.getDefaultPost();

    public static void main(String[] args) {
        CompletableFuture.allOf(usersAddPosts().toArray(new CompletableFuture[0]))
                .thenRun(Main::printServicePosts)
                .join();
        CompletableFuture.allOf(usersDeletePosts().toArray(new CompletableFuture[0]))
                .thenRun(Main::printServicePosts)
                .join();
        CompletableFuture.allOf(usersAddComments().toArray(new CompletableFuture[0]))
                .thenRun(Main::printPostComments)
                .join();
        CompletableFuture.allOf(usersDeleteComments().toArray(new CompletableFuture[0]))
                .thenRun(Main::printPostComments)
                .join();
    }

    private static List<CompletableFuture<Void>> usersAddPosts() {
        log.info("Add posts test:");
        return posts
                .stream()
                .map(post -> CompletableFuture.runAsync(() -> postService.addPost(post)))
                .toList();
    }

    private static List<CompletableFuture<Void>> usersDeletePosts() {
        log.info("Delete posts test:");
        return IntStream
                .range(0, users.size())
                .mapToObj(i -> CompletableFuture.runAsync(() ->
                        postService.deletePost(users.get(i), posts.get(i).getId())))
                .toList();
    }

    private static void printServicePosts() {
        log.info("Print posts in service:");
        postService.getPosts()
                .values()
                .stream()
                .filter(post -> !post.isDeleted())
                .forEach(post -> log.info("{}", post));
    }

    private static List<CompletableFuture<Void>> usersAddComments() {
        log.info("Add comments test:");
        postService.addPost(defaullPost);
        return comments
                .stream()
                .map(comment -> CompletableFuture.runAsync(() -> postService.addComment(DEFAULT_POST_ID, comment)))
                .toList();
    }

    private static List<CompletableFuture<Void>> usersDeleteComments() {
        log.info("Delete comments test:");
        return IntStream
                .range(0, users.size())
                .mapToObj(i -> CompletableFuture.runAsync(() ->
                        postService.deleteComment(users.get(i), defaullPost.getId(), comments.get(i))))
                .toList();
    }

    private static void printPostComments() {
        log.info("Print comments of post with id: {}", DEFAULT_POST_ID);
        defaullPost.getComments()
                .values()
                .forEach(comment -> log.info("{}", comment));
    }
}
