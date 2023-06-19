package faang.school.godbless.sprint2.meta;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    private Map<String, Consumer<Notification>> handlers = new HashMap<>();
    private List<Predicate<Notification>> filters = new ArrayList<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        handlers.put(type, consumer);
    }

    public void setFilters(Predicate<Notification> predicate){
        filters.add(predicate);
    }

    public void sendNotification(Notification notification) {
        String identifier = notification.getType();
        Optional.ofNullable(handlers.get(identifier))
                .ifPresent(handler -> {
                    boolean validateMessage = filters.stream()
                            .allMatch(entry -> entry.test(notification));

                    if (validateMessage) {
                        System.out.println("Сообщение содержит неприемлемый контент : " + notification.getMessage());
                    } else {
                        handler.accept(notification);
                    }
                });
    }

}
