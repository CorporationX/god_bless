package school.faang.sprint_2.task_46975;

import java.util.Map;
import java.util.function.Consumer;
import java.util.concurrent.ConcurrentHashMap;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlers = new ConcurrentHashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        handlers.entrySet().stream()
                .filter(entry -> entry.getKey().equals(notification.type()))
                .findFirst()
                .map(Map.Entry::getValue)
                .ifPresentOrElse(handler -> handler.accept(notification), () ->
                        System.out.println("Обработчик для типа \""
                                + notification.type() + "\" не зарегистрирован"));
    }
}