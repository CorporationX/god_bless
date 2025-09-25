package school.faang.bjs2_93733;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        PostService postService = new PostService();
        Post post1 = new Post(1, "111 111 111 111", "Глаша");
        Post post2 = new Post(2, "222 222 222 222", "Дуся");
        Comment comment1 = new Comment("Вася", "Comment 1");
        Comment comment2 = new Comment("Маша", "Comment 2");
        Comment comment3 = new Comment("Петя", "Comment 3");
        List<Thread> threads = List.of(
                new Thread(() -> postService.addPost(post1)),
                new Thread(() -> postService.addComment(post1.getId(), comment1)),
                new Thread(() -> postService.addPost(post2)),
                new Thread(() -> postService.addComment(post2.getId(), comment2)),
                new Thread(() -> postService.addComment(post2.getId(), comment3)),
                new Thread(() -> postService.deletePost("Миша", post2)),
                new Thread(() -> postService.deleteComment("Петя", post2, comment3))
        );
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        log.info("Все операции завершены.");
    }
}
