package school.faang.task_51253;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    public static final int THREAD_COUNT = 5;
    private static final AtomicInteger ID_COUNT = new AtomicInteger(0);

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];
        PostService postService = new PostService();

        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(() -> {
                Post post = new Post(ID_COUNT.incrementAndGet());
                Comment comment = new Comment("text");
                postService.addPost(post);
                postService.addComment(post.getId(), comment);
                System.out.println("Пост " + post.getId() + " создан, комментарий " + comment.getText() + " создан");
                postService.viewComment(post);
                postService.deleteComment(comment, post, "N");
                postService.deletePost(post, "Рыбак");
            });
            threads[i].start();
        }

        for (int i = 0; i < THREAD_COUNT; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                log.warn("Ошибка {1}", e);
            }
        }
    }
}
