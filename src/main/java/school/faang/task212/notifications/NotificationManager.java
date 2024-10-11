package school.faang.task212.notifications;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class NotificationManager {

    private final Map<String, Consumer<Notification>> notificationHandlers = new HashMap<>();

    private final Set<String> badWords = new HashSet<>();

    {
        Stream.of("firstbadword", "secondbadword", "thirdbadword").forEach(badWords::add);
    }

    public void addBadWord(String badWord) {
        badWords.add(badWord);
    }

    public void removeBadWord(String badWord) {
        badWords.remove(badWord);
    }

    private final Predicate<Notification> predicateForAdultContent =
            (notification) -> {
                String[] words = notification.getMessage()
                        .replaceAll("[^a-zA-Z\\s]", "")
                        .toLowerCase()
                        .split("\\s");
                for (String word : words) {
                    if (badWords.contains(word)) {
                        return true;
                    }
                }
                return false;
            };

    public void registerHandler(String type, Consumer<Notification> consumer) {
        notificationHandlers.put(type, consumer);
    }

    public void sendNotification(boolean checkForAdultWords, Notification notification) {
        if (notificationHandlers.containsKey(notification.getType())) {
            if (checkForAdultWords) {
                if (!predicateForAdultContent.test(notification)) {
                    notificationHandlers.get(notification.getType()).accept(notification);
                } else {
                    System.out.println("Плохие слова");
                }
            } else {
                notificationHandlers.get(notification.getType()).accept(notification);
            }
        } else {
            System.out.println("Ошибка");
        }
    }
}
