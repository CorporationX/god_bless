package school.faang.comments;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        PostService postService = new PostService();

        User user1 = new User("Nikita");
        User user2 = new User("Vlad");
        User user3 = new User("Gena");

        executorService.submit(() -> postService.addPost(new Post("first post", "hello", user1.getId())));
        executorService.submit(() -> postService.addPost(new Post("second post", "hi", user1.getId())));
        executorService.submit(() -> postService.addPost(new Post("third post", "eue", user1.getId())));
        executorService.submit(() -> postService.addPost(new Post("title 1", "my post", user2.getId())));
        executorService.submit(() -> postService.addPost(new Post("title 2", "qwe", user3.getId())));

        executorService.submit(() -> postService.addComment(1, new Comment("good", user2)));
        executorService.submit(() -> postService.addComment(2, new Comment("like", user2)));
        executorService.submit(() -> postService.addComment(3, new Comment("zxc", user2)));
        executorService.submit(() -> postService.addComment(3, new Comment("hi", user1)));
        executorService.submit(() -> postService.addComment(3, new Comment("hello", user3)));
        executorService.submit(() -> postService.addComment(4, new Comment("nice", user1)));
        executorService.submit(() -> postService.addComment(5, new Comment("wow", user1)));

        executorService.shutdown();

        try {
            if(executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                log.info("поток main дождался завершения дугих потоков");

                for (int i = 1; i <= 5; i++) {
                    postService.showPost(i);
                }

                postService.showCommentsByPost(3);
            }else {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("поток main не дождался завершения других потоков ", e);
            throw new IllegalStateException(e);
        }
    }
}
