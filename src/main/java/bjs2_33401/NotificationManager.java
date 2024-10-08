package bjs2_33401;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class NotificationManager {
    public static Map<String, Consumer<Notification>> notificationTypeResponse = new HashMap<>();
    public static Set<String> unacceptableWords = Set.of("drugs", "alcohol");

    public void registerHandler(String type, Consumer<Notification> consumer) {
        notificationTypeResponse.put(type, consumer);
    }

    public void sendNotification(Notification notification) {
        preprocessNotificationMessage(notification, 20);
        notificationTypeResponse.get(notification.getType()).accept(notification);
    }

    public void preprocessNotificationMessage(Notification notification, int maxWords) {
        if (isLongMessage(notification, maxWords)) {
            shortenNotificationMessage(notification, maxWords);
        }
        blurUnacceptableWords(notification);
    }

    public boolean isLongMessage(Notification notification, int maxWords) {
        return notification.getMessage().split(" ").length > maxWords;
    }

    // Логика в том, что в реальном мире в самих уведомлениях не бывает
    // очень длинных оповещений. Обычно ограничиваются 1-4 строчками.
    public void shortenNotificationMessage(Notification notification, int maxWords) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] messageWords = notification.getMessage().split(" ");

        for (int i = 0; i < maxWords; i++) {
            stringBuilder.append(messageWords[i]).append(" ");
        }
        notification.setMessage(stringBuilder.toString().trim());
    }

    public void blurUnacceptableWords(Notification notification) {
        String message = notification.getMessage();

        for (String word : unacceptableWords) {
            // меняем слова без учета регистра
            message = message.replaceAll("(?i)" + word, "***");
        }
        notification.setMessage(message);
    }
}
