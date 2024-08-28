package faang.school.godbless.BJS2_24400;

import lombok.NonNull;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ChatManager {
    private BlockingQueue<User> queue = new LinkedBlockingQueue<>();
    private static ExecutorService executor = Executors.newCachedThreadPool();

    public void start() {
        System.out.println("Начать работу");
        while (true) {
            try {
                User user1 = queue.poll(10, TimeUnit.SECONDS);
                User user2 = queue.poll(10, TimeUnit.SECONDS);

                if (user1 != null && user2 != null) {
                    createChat(user1, user2);
                } else {
                    System.out.println("Прекращаем работу!");
                    if (user1 != null) {
                        stopExecutorService(user1);
                    } else {
                        stopExecutorService();
                    }
                    break;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    private void createChat(User user1, User user2) {
        executor.execute(() -> {
            Chat chat = new Chat(user1, user2);
            chat.communicate();
        });
    }

    private void stopExecutorService(User remainingUser) {
        System.out.println(remainingUser + " извините, у нас обед");
        stopExecutorService();
    }

    private void stopExecutorService() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(3, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    public void startChat(@NonNull User user) {
        try {
            queue.put(user);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}