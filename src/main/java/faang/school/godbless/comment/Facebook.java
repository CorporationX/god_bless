package faang.school.godbless.comment;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Facebook {
    public static void main(String[] args) {
        PostService postService = new PostService();

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(() -> {
            postService.addPost(new Post("How to code Java", "text", postService.getUsersMap().get(1)));
        });
        executorService.execute(() -> {
            postService.addPost(new Post("How to code C#", "text", postService.getUsersMap().get(2)));
        });
        executorService.execute(() -> {
            postService.addPost(new Post("How to code JavaScript", "text", postService.getUsersMap().get(3)));
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        executorService.execute(() -> {
            postService.addComment(1, new Comment("Hello"), 1);
        });
        executorService.execute(() -> {
            postService.addComment(1, new Comment("I am first!"), 2);
        });
        executorService.execute(() -> {
            postService.addComment(1, new Comment("World!"), 4);
        });
        executorService.execute(() -> {
            postService.addComment(2, new Comment("World!"), 1);
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        executorService.execute(() -> {
            postService.deletePost(1, 2);
        });
        executorService.execute(() -> {
            postService.deleteComment(0, 1, 2);
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        executorService.execute(() -> {
            postService.checkComment(0, 0);
        });
        executorService.execute(() -> {
            postService.checkPost(1);
        });
        executorService.execute(() -> {
            postService.checkPost(2);
        });

        executorService.shutdown();
    }
}
