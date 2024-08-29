package faang.school.godbless.BJS2_25310;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();

        List<Thread> postsThreads = Arrays.asList(
                new Thread(() -> postService.addPost(new Post(1, "Первый пост", "Текст первого поста", "Сашка"))),
                new Thread(() -> postService.addPost(new Post(2, "Второй пост", "Текст второго поста", "Маша"))
                ));
        postsThreads.forEach(Thread::start);
        postsThreads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        List<Thread> commentsThreads = Arrays.asList(
                new Thread(() -> postService.addComment(new Comment("Отличный пост!", "Таня", LocalDateTime.now()), 1)),
                new Thread(() -> postService.addComment(new Comment("Согласен, хороший пост!", "Петя", LocalDateTime.now()), 1)),
                new Thread(() -> postService.addComment(new Comment("Второй пост тоже хорош!", "Андрей", LocalDateTime.now()), 2)
                ));
        commentsThreads.forEach(Thread::start);
        commentsThreads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        postService.viewPosts();
        postService.deleteComment(1, "Таня");
        postService.viewPosts();
        postService.deletePost(1, "Сашка");
        postService.viewPosts();
    }
}
