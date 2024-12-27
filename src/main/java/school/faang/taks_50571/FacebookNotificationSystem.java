package school.faang.taks_50571;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FacebookNotificationSystem {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        // Запуск асинхронного добавления уведомлений
        List<CompletableFuture<Void>> futures = IntStream.range(0, 10)
                .mapToObj(i -> manager.fetchNotification(i, "Сообщение " + i))
                .collect(Collectors.toList());

        // Ожидание завершения всех задач
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFutures.join(); // Ждем завершения


        // Вывод всех уведомлений
        manager.printNotifications();
    }
}
