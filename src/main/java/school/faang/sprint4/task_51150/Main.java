package school.faang.sprint4.task_51150;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();

        IntStream.range(0, 10).forEach(i -> {
            Post post = new Post(i, "Post " + i, "Content for post " + i, "Author" + i);
            postService.addPost(post);
        });

        List<CompletableFuture<?>> futures = new ArrayList<>();

        IntStream.range(0, 50).forEach(i -> {
            futures.add(CompletableFuture.runAsync(() -> {
                int postId = ThreadLocalRandom.current().nextInt(1000, 2000);
                String title = "Generated Post " + postId;
                String content = "Content of post " + postId;
                String author = "User" + ThreadLocalRandom.current().nextInt(1, 20);
                Post post = new Post(postId, title, content, author);
                postService.addPost(post);
            }));

            futures.add(CompletableFuture.runAsync(() -> {
                int postId = ThreadLocalRandom.current().nextInt(0, 10);
                int commentId = ThreadLocalRandom.current().nextInt(100, 1000);
                String text = "Comment " + commentId;
                String author = "User" + ThreadLocalRandom.current().nextInt(1, 20);
                Comment comment = new Comment(commentId, text, author);
                postService.addComment(postId, comment);
            }));
        });

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        postService.printAllPosts();
    }
}
