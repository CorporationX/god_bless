package school.faang.bjs2_87592;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    private List<String> badWords = Arrays.asList("сука", "нахуй", "тварь");
    private Map<NotificationType, Consumer<Notification>> notificationHandler = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (type == null) {
            throw new IllegalArgumentException("Уведомление не может быть пустым");
        }
        if (handler == null) {
            throw new IllegalArgumentException("Обработчки не может быть пустым");
        }
        notificationHandler.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Оповещения не могут быть пустыми");
        }

        String originalMessage = notification.getMessage();
        String censoredMessage = censorMessage(originalMessage);

        Notification censoredNotification = new Notification(
                notification.getType(),
                censoredMessage
        );
        Consumer<Notification> handler = notificationHandler.get(notification.getType());

        if (handler != null) {
            handler.accept(censoredNotification);
            System.out.println("Обработчик " + handler);
        } else {
            System.out.println("Обработчик для данного типа не найден");
        }
    }

    public Predicate<String> createBadWordsFilter() {
        return word -> badWords.stream()
                .map(badWord -> badWord.toLowerCase())
                .anyMatch(badWord -> word.toLowerCase().contains(badWord));
    }

    public String censorMessage(String message) {
        if (message == null) {
            return null;
        }
        String[] words = message.split("\\s+");
        Predicate<String> badWordsFilter = createBadWordsFilter();

        for (int i = 0; i < words.length; i++) {
            if (badWordsFilter.test(words[i])) {
                words[i] = "*".repeat(words[i].length());
            }
        }
        return String.join(" ", words);
    }
}
