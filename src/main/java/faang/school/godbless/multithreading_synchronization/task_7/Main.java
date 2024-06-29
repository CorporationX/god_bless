package faang.school.godbless.multithreading_synchronization.task_7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_COUNT = 10;
    private static final int TIME_OUT = 40;

    public static void main(String[] args) {
        final ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        final ChatManager chatManager = new ChatManager();
        final User currentUser = new User("Kostah", Status.ONLINE);
        for (int i = 0; i < THREAD_COUNT / 2; i++) {
            executor.submit(() -> chatManager.waitForChat(currentUser));
            executor.submit(() -> {
                chatManager.startChat(currentUser, MessageProvider.getRandomMessage());
                chatManager.stopChat(currentUser);
            });
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIME_OUT, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                System.out.println("Program finished successfully");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted");
        }
    }
}
