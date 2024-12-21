package school.faang.sprint2.task_46926;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class NotificationManager {

    private Map<String, Consumer<Notification>> typeByConsumer = new HashMap<>();
    private Map<String, Consumer<Notification>> typeByBadWords = new HashMap<>();
    private Set<String> badWordSet = Set.of("fuck", "shit", "dumbass");

    void registerHandler(String type, Consumer<Notification> handler) {
        typeByConsumer.put(type, handler);
    }

    void sendNotification(Notification notification) {
        typeByConsumer.get(notification.getType()).accept(notification);
    }

    void registerBadWord(
            String type,
            Consumer<Notification> badWord
    ) {
        typeByBadWords.put(type, badWord);
    }

    void checkBadWord(Notification notification) {
        String initialMessage = notification.getMessage();
        badWordSet.forEach(badWord -> {
            String newWord = notification.getMessage().replaceAll(badWord, "*".repeat(badWord.length()));
            notification.setMessage(newWord);
        });
        if (!initialMessage.equals(notification.getMessage())) {
            typeByBadWords.get(notification.getType()).accept(notification);
            sendNotification(notification);
        }
    }
}
