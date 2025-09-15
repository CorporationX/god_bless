package school.faang.bjs2_87764;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {

    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();
    private final Map<String, Predicate<Notification>> filters = new HashMap<>();
    private final List<Function<Notification, Notification>> editors = new ArrayList<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void registerFilter(String filterName, Predicate<Notification> filter) {
        filters.put(filterName, filter);
    }

    public void registerEditor(Function<Notification, Notification> editor) {
        editors.add(editor);
    }

    public void sendNotification(@NonNull Notification notification) {
        Notification editedNotification = applyEditors(notification);
        for (Map.Entry<String, Predicate<Notification>> filterEntry : filters.entrySet()) {
            if (!filterEntry.getValue().test(editedNotification)) {
                System.out.println("Blocked by filter: " + filterEntry.getKey());
                return;
            }
        }

        Consumer<Notification> handler = handlers.get(editedNotification.getType());
        if (handler != null) {
            handler.accept(editedNotification);
        } else {
            System.out.println("No handler for: " + editedNotification.getType());
        }
    }

    private Notification applyEditors(Notification notification) {
        Notification result = notification;
        for (Function<Notification, Notification> editor : editors) {
            result = editor.apply(result);
        }
        return result;
    }
}
