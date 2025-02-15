package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

@Slf4j
public class NotificationManager {
    private final Map<Notification.NotificationType, Consumer<Notification>> notificationHandlers = new HashMap<>();
    private final List<String> forbiddenWords = new ArrayList<>();
    private final List<Function<Notification, Notification>> messageCorrectors = new ArrayList<>();

    public NotificationManager(List<String> forbiddenWords) {
        this.forbiddenWords.addAll(forbiddenWords);
    }

    public static void main(String[] args) {
        // Пример списка запрещенных слов
        List<String> forbiddenWords = List.of("ЪуЪ");

        NotificationManager notificationManager = new NotificationManager(forbiddenWords);

        notificationManager.registerHandler(Notification.NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.getMessage()));
        notificationManager.registerHandler(Notification.NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage()));
        notificationManager.registerHandler(Notification.NotificationType.PUSH,
                notification -> System.out.println("PUSH: " + notification.getMessage()));

        Notification emailNotification = new Notification(Notification.NotificationType.EMAIL,
                "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(Notification.NotificationType.SMS,
                "Ваш пароль ЪуЪ");
        Notification pushNotification = new Notification(Notification.NotificationType.PUSH,
                "У вас новое сообщение!");
        Notification blockedNotification = new Notification(Notification.NotificationType.SMS,
                "Это сообщение содержит нецензурное слово");

        notificationManager.registerMessageCorrector(notification -> {
            String correctedMessage = notification.getMessage() + "\nС уважением, Meta.";
            return new Notification(notification.getType(), correctedMessage);
        });

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(blockedNotification);
    }

    public void registerMessageCorrector(Function<Notification, Notification> corrector) {
        messageCorrectors.add(corrector);

    }

    public void registerHandler(Notification.NotificationType type, Consumer<Notification> handler) {
        notificationHandlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (isForbidden(notification)) {
            log.info("Уведомление заблокировано: " + notification.getMessage());
            return;
        }
        for (Function<Notification, Notification> corrector : messageCorrectors) {
            notification = corrector.apply(notification);
        }

        Consumer<Notification> handler = notificationHandlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            log.info("Обработчик для типа уведомления не найден: " + notification.getType());
        }
    }

    private boolean isForbidden(Notification notification) {
        String message = notification.getMessage().toLowerCase();
        for (String word : forbiddenWords) {
            if (message.contains(word.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}




