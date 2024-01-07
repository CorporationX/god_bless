package faang.school.godbless.LeaveComment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static final int THREAD_COUNT = 3;
    private static final int INCREMENT_COUNT = 10;
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        PostService postService = new PostService(new ArrayList<>());
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            Post post = new Post(i, "Вася", "Такой пост", "Содержание поста", new ArrayList<>());
            int finalI = i;
            threads[i] = new Thread(() -> {
                postService.addPost(post);
                for (int j = 0; j < INCREMENT_COUNT; j++) {
                    lock.lock();
                    try {
                        postService.addComment(post, new Comment("Ася", " новый комментарий " + j, new SimpleDateFormat("dd-MM HH:mm:ss").format(new Date())));
                    } finally {
                        lock.unlock();
                    }
                    if (j % 3 == 0) {
                        postService.deleteComment("Ася", " новый комментарий " + j, finalI);
                    }
                }
                postService.viewingPosts(finalI);
            });
            threads[i].start();
        }
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i].join();
        }
        System.out.println();
    }
}
