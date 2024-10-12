package bjs2_33401;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

@Getter
public class NotificationManager {
    private Map<String, Consumer<Notification>> responseByNotificationType = new HashMap<>();
    private Map<String, Function<String, String>> filterByNotificationType = new HashMap<>();
    private static final Set<String> UNACCAPTABLE_WORDS = Set.of("drugs", "alcohol");

    public void registerHandler(String type, Consumer<Notification> consumer) {
        responseByNotificationType.put(type, consumer);
    }

    public void registerFilter(String type, Function<String, String> function) {
        filterByNotificationType.put(type, function);
    }

    public void sendNotification(Notification notification) {
        preprocessNotificationMessage(notification, 20);
        responseByNotificationType.get(notification.getType()).accept(notification);
    }

    public void preprocessNotificationMessage(Notification notification, int maxWords) {
        if (isLongMessage(notification, maxWords)) {
            shortenNotificationMessage(notification, maxWords);
        }
        blurUnacceptableWords(notification, filterByNotificationType.get(notification.getType()));
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

    public void blurUnacceptableWords(Notification notification,
                                      Function<String, String> messageFilter) {
        String message = notification.getMessage();

        for (String word : UNACCAPTABLE_WORDS) {
            message = messageFilter.apply(message);
        }
        notification.setMessage(message);
    }

    public static Set<String> getUnaccaptableWords() {
        return UNACCAPTABLE_WORDS;
    }
}
