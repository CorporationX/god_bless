package faang.school.godbless;

import faang.school.godbless.data.manager.NotificationManagerImpl;
import faang.school.godbless.domain.manager.NotificationManager;
import faang.school.godbless.domain.model.Notification;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(MAXIMUM_POOL_SIZE);

        NotificationManager notificationManager =
                new NotificationManagerImpl(executorService);

        final int countNotification = new Random().nextInt(100) + 80;

        System.out.println(countNotification + " - notifications scheduled");

        CompletableFuture<Notification>[] awaitableNotification = new CompletableFuture[countNotification];

        for (int i = 0; i < countNotification; i++) {
            awaitableNotification[i] = notificationManager.fetchNotification();
        }

        CompletableFuture.allOf(awaitableNotification).join();

        executorService.shutdown();

        for (CompletableFuture<Notification> completableFuture : awaitableNotification) {
            try {
                System.out.println(completableFuture.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}