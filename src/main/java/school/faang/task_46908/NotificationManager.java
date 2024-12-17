package school.faang.task_46908;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(String noteId, Consumer<Notification> note) {
        handlers.put(noteId, note);
    }

    public void sendNotification(Notification note) {
        Consumer<Notification> handler = handlers.get(note.getType());
        if (handler != null) {
            handler.accept(note);
        } else {
            System.out.println("No handler found for notification type: " + note.getType());
        }
    }

}
