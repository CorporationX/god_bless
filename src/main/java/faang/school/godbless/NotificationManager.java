package faang.school.godbless;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private static final Map<String, Consumer<Notification>> notifications = new HashMap<>();
    private static final List<String> spamWords = List.of("spam1", "spam2", "spam3",
            "spam4", "spam5", "spam6");

    public void addSpamWord(@NonNull String word) {
        spamWords.add(word);
    }

    @NonNull
    public void registerHandler(
            String identifierNotification, Consumer<Notification> notificationConsumer) {
        notifications.put(identifierNotification, notificationConsumer);
    }

    public void sendNotification(@NonNull Notification notification) {
        notifications.get(notification.getType());
    }

    public void checkNotificationOnSpam(Notification notification) {
        spamWords.forEach(word -> {
            if (notification.getMessage().toLowerCase().contains(word)) {
                notification.changeIsSpam(true);
            }
        });
    }
}