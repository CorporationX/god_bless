package bjs2_61828;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class FacebookNotificationSystem {
    public static final int MESSAGE_COUNT = 10;

    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        // Запуск асинхронного добавления уведомлений
        var futures = IntStream.range(0, MESSAGE_COUNT)
                .mapToObj(i -> manager.fetchNotification(i, "Сообщение " + i))
                .toList();

        // Ожидание завершения всех задач
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        // Вывод всех уведомлений
        manager.printNotifications();
    }
}
