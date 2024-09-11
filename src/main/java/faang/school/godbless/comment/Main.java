package faang.school.godbless.comment;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {

    private static final Random GREAT_RANDOM = new Random();
    private static final int LIMIT_COMMENTS = 500;
    private static final int LIMIT_DELETE_POSTS = 2;

    public static void main(String[] args) throws InterruptedException {
        PostService postService = new PostService();

        List<Author> authors = List.of(
                new Author("Jason", "Statham"),
                new Author("Biba", "Bibovich"),
                new Author("Boba", "Bobovich")
        );

        List<Post> posts = List.of(
                new Post("New post", "Just text", authors.get(GREAT_RANDOM.nextInt(authors.size()))),
                new Post("Another post", "Just text", authors.get(GREAT_RANDOM.nextInt(authors.size()))),
                new Post("New post", "Just text", authors.get(GREAT_RANDOM.nextInt(authors.size()))),
                new Post("New post", "Just text", authors.get(GREAT_RANDOM.nextInt(authors.size())))
        );

        List<Comment> comments = List.of(
                new Comment("Nice post"),
                new Comment("Interesting post"),
                new Comment("LOL"),
                new Comment("LMAO"),
                new Comment(":)"),
                new Comment("Test"),
                new Comment("Random comment")
        );

        ExecutorService executorService = Executors.newCachedThreadPool();

        CompletableFuture.allOf(
                posts.stream()
                        .map(post -> CompletableFuture.runAsync(() -> postService.addPost(post), executorService))
                        .toArray(CompletableFuture[]::new)
        ).join();

        CompletableFuture.allOf(
                IntStream.range(0, LIMIT_COMMENTS)
                        .mapToObj(i -> CompletableFuture.runAsync(() -> postService.addComment(
                                comments.get(GREAT_RANDOM.nextInt(comments.size())),
                                posts.get(GREAT_RANDOM.nextInt(posts.size()))), executorService))
                        .toArray(CompletableFuture[]::new)

        ).join();
        postService.printAllPosts();

        posts.stream()
                .limit(LIMIT_DELETE_POSTS)
                .forEach(post -> new Thread(() -> postService.deletePost(
                        posts.get(GREAT_RANDOM.nextInt(posts.size())),
                        authors.get(GREAT_RANDOM.nextInt(authors.size()))))
                        .run());

        postService.printAllPosts();
        executorService.shutdown();
    }
}
