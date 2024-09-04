package faang.school.godbless.comments;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 99;
    private static ExecutorService service;

    public static void main(String[] args) throws InterruptedException {
        service = Executors.newFixedThreadPool(NUM_THREADS);

        PostService postService = new PostService();

        postService.addPost(new Post("1", "first"));
        postService.addPost(new Post("2", "second"));
        postService.addPost(new Post("3", "third"));

        for (int i = 0; i < NUM_THREADS / 3; i++) {
            int finalI = i;
            service.execute(() -> postService.addComment(new Comment("1" + finalI), 1));
            service.execute(() -> postService.addComment(new Comment("2" + finalI), 2));
            service.execute(() -> postService.addComment(new Comment("3" + finalI), 3));
        }

        stopService();

        new Thread(() -> {
            Comment comment = new Comment("1sp");
            postService.addComment(comment, 1);
            postService.viewPostsWithComments();
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            postService.deleteComment(comment, 1);
            postService.viewPostsWithComments();
        }, "comm").start();

        Thread.sleep(3_000);

        Comment newComment = new Comment("newComment");//для проверки того, что нельзя удалить комм,
        // который создал не ты
        postService.addComment(newComment, 1);


        new Thread(() -> {
            postService.addPost(new Post("postTitle", "postBody"));
            postService.viewPostsWithComments();
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            postService.deleteComment(newComment, 1);//тут должно вылезти сообщение, что так нельзя
            postService.deletePost(2);//тут тоже
        }, "post").start();
        Thread.sleep(3_000);
    }

    private static void stopService() {
        service.shutdown();
        try {
            if (!service.awaitTermination(3_000, TimeUnit.MILLISECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }
}
