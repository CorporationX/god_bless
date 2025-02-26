package school.faang.sprint4.bjs2_62623;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();
        AtomicInteger postIdCounter = new AtomicInteger(0);
        AtomicInteger deletedPostCounter = new AtomicInteger(0);
        Lock deletionLock = new ReentrantLock();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                String user = "Пользователь " + Thread.currentThread().getId();
                int postId = postIdCounter.incrementAndGet();

                Post post = new Post(postId, "Заголовок " + postId, "Текст от " + user, user);
                postService.addPost(post);
                System.out.println(user + " добавил пост " + postId);

                int randomPostId = ThreadLocalRandom.current().nextInt(1, postId + 1);
                Comment comment = new Comment("Комментарий", user);
                postService.addComment(randomPostId, comment);
                System.out.println(user + " прокоментировал пост " + randomPostId);

                deletionLock.lock();
                try {
                    if (deletedPostCounter.get() < 3 && postService.deletePost(postId, user)) {
                        System.out.println(user + " удалил пост " + postId);
                        deletedPostCounter.incrementAndGet();
                    }
                } finally {
                    deletionLock.unlock();
                }

            });

        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("\nОставшиеся посты:");
        for (int i = 1; i <= postIdCounter.get(); i++) {
            Post post = postService.getPost(i);
            if (post != null) {
                System.out.println("Пост " + post.getId() + ": " + post.getTitle() + " от " + post.getAuthor());
                System.out.println("Комментарии:");
                for (Comment comment : post.getComments()) {
                    System.out.println(" - " + comment.getText() + " от " + comment.getAuthor());
                }
            }
        }
    }
}