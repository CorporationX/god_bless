package faang.school.godbless.Metaverse;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> handlers = new HashMap<>();
    @Setter
    private Consumer<Notification> defaultHandler = n -> System.out.println("No handler registered for notification ID: " + n.getType());

    public void registerHandler(String type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(String type, Notification notification) {
        Consumer<Notification> handler = handlers.getOrDefault(type, defaultHandler);
        handler.accept(notification);
    }

    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        manager.registerHandler("INFO", n -> System.out.println("Info: " + n.getMessage()));
        manager.registerHandler("WARNING", n -> System.out.println("Warning: " + n.getMessage()));
        manager.registerHandler("ERROR", n -> System.out.println("Error: " + n.getMessage()));

        Notification infoNotification = new Notification("INFO", "This is an informational message.");
        Notification warningNotification = new Notification("WARNING", "This is a warning message.");
        Notification errorNotification = new Notification("ERROR", "This is an error message.");

        manager.sendNotification("INFO", infoNotification);
        manager.sendNotification("WARNING", warningNotification);
        manager.sendNotification("ERROR", errorNotification);
        manager.sendNotification("UNKNOWN", new Notification("UNKNOWN", "This notification type is not registered."));
    }
}