package faang.school.godbless.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> typeHandlers = new HashMap<>();
    private final Map<String, Predicate<Notification>> contentBlockers = new HashMap<>();
    private final Map<String, Function<String,String>> contentEditors = new HashMap<>();

    public void registerTypeHandler(String type, Consumer<Notification> handler) {
        typeHandlers.put(type, handler);
    }

    public void registerContentEditor(String type, Function<String,String> handler) {
        contentEditors.put(type, handler);
    }

    public void registerContentBlocker(String type, Predicate<Notification> handler) {
        contentBlockers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        for (var entry : contentBlockers.entrySet()){
            var contentBlocker = entry.getValue();
            if (contentBlocker.test(notification)){
                throw new IllegalArgumentException("Cannot be sent. Contains " + entry.getKey());
            }
        }
        for (var entry : contentEditors.entrySet()){
            var contentEditor = entry.getValue();
            notification.setMessage(contentEditor.apply(notification.getMessage()));
        }
        typeHandlers.get(notification.getType()).accept(notification);
    }
}
