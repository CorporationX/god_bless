package school.faang.task212.notifications;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {

    private static final HashMap<String, Consumer<Notification>> notificationHandler = new HashMap<>();
    private static final MyPredicate<String, Notification> myPredicate =
            (set, notification) -> {
                String[] words = notification.getMessage()
                        .replaceAll("[^a-zA-Z\\s]", "")
                        .toLowerCase()
                        .split("\\s");

                for (String word : words) {
                    if (set.contains(word)) return true;
                }
                return false;
            };

    public void registerHandler(String type, Consumer<Notification> consumer) {
        notificationHandler.put(type, consumer);
    }

    public void sendNotification(Set<String> badWordsMap, Notification notification) {
        if (notificationHandler.containsKey(notification.getType())) {
            if (!myPredicate.test(badWordsMap, notification)) {
                notificationHandler.get(notification.getType()).accept(notification);
            }

            else {
                System.out.println("Плохие слова");
            }

        }

        else {
            System.out.println("Ошибка");
        }
    }
}
