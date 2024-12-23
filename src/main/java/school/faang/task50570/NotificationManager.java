package school.faang.task50570;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class NotificationManager {
    private static final Random RANDOM = new Random();
    private static final int TIME_RANGE = 10;

    private final List<Notification> notifications = new ArrayList<>();

    private synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public CompletableFuture<Void> fetchNotification(Notification notification) {
        Objects.requireNonNull(notification);

        return CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(RANDOM.nextInt(TIME_RANGE));

                addNotification(notification);
                log.info("Добавлено уведомление: {}", notification.message());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Произошла ошибка при добавлении {}", notification, e);
            }
        });
    }
}
