package dima.evseenko.comment;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PostService postService = new PostService();

        Post post = new Post(1, "Igor", "Title", "Content");
        postService.addPost(post);

        ExecutorService executorService = Executors.newCachedThreadPool();

        getComments().forEach(comment -> executorService.submit(() -> postService.addComment(1, comment)));

        executorService.shutdown();

        if (executorService.awaitTermination(100, TimeUnit.SECONDS)) {
            postService.printPosts();
            postService.printComments(1);

            postService.deleteComment(1, 1);
            postService.printComments(1);

            postService.deletePost(1);
            postService.printPosts();
        }
    }

    private static List<Comment> getComments() {
        return List.of(
                new Comment(1, "Dima", "Text1..."),
                new Comment(2, "Vasya", "Text2..."),
                new Comment(3, "Petya", "Text3..."),
                new Comment(4, "Kolya", "Text4..."),
                new Comment(5, "Sasha", "Text5..."),
                new Comment(6, "Masha", "Text6...")
        );
    }
}
