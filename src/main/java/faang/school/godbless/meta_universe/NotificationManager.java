package faang.school.godbless.meta_universe;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private Map<String, Consumer<Notification>> notificationsByType = new HashMap<>();
    private Map<Predicate<Notification>, Function<Notification, Notification>> notificationFilters = new HashMap<>();

    public void registerHandler(@NonNull String type, @NonNull Consumer<Notification> notificationConsumer) {
        notificationsByType.put(type, notificationConsumer);
    }

    public void sendNotification(@NonNull Notification notification) {
        Consumer<Notification> notificationConsumer = notificationsByType.get(notification.getType());
        if (notificationConsumer == null) {
            throw new IllegalArgumentException("Notification type not found");
        }

        filterNotification(notification);
        notificationConsumer.accept(notification);
    }

    public void addFilter(@NonNull Predicate<Notification> predicate, @NonNull Function<Notification, Notification> filterAction) {
        notificationFilters.put(predicate, filterAction);
    }

    private void filterNotification(Notification notification) {
        for (Map.Entry<Predicate<Notification>, Function<Notification, Notification>> entry : notificationFilters.entrySet()) {
            if (entry.getKey().test(notification)) {
                Notification changedNotification = entry.getValue().apply(notification);

                notification.setType(changedNotification.getType());
                notification.setMessage(changedNotification.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        Set<String> badWords = Set.of("bitch", "damn", "shit");

        Predicate<Notification> predicateForBadWords = (notification) -> {
            for (String word : badWords) {
                if (notification.getMessage().toLowerCase().contains(word)) {
                    return true;
                }
            }
            return false;
        };

        Function<Notification, Notification> filterForBadWords = (notification) -> {
            for (String word : badWords) {
                notification.setMessage(notification.getMessage().replaceAll(word, "*".repeat(word.length())));
            }

            return notification;
        };

        notificationManager.addFilter(predicateForBadWords, filterForBadWords);

        notificationManager.registerHandler("email", (notification) -> System.out.printf("Отправка уведомления типа '%s' с сообщением: '%s'\n", notification.getType(), notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) -> System.out.printf("Отправка уведомления типа '%s' с сообщением: '%s'\n", notification.getType(), notification.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.printf("Отправка уведомления типа '%s' с сообщением: '%s'\n", notification.getType(), notification.getMessage()));

        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");
        Notification someNotification = new Notification("sms", "i'll kill you, bitch");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(someNotification);
    }
}
