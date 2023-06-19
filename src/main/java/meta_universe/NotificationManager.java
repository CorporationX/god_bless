package meta_universe;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Getter
public class NotificationManager {
    private Map<String, Consumer<Notification>> handlers;
    private Map<Predicate<Notification>, Consumer<Notification>> contentFilter;

    public NotificationManager() {
        this.handlers = new HashMap<>();
        this.contentFilter = new HashMap<>();
    }

    public void registerHandler(String identifier, Consumer<Notification> handler) {
        handlers.put(identifier, handler);
    }

    public void registerContentFilter(Predicate<Notification> filter, Consumer<Notification> action) {
        contentFilter.put(filter, action);
    }

    public void sendNotification(Notification notification) {
        String identifier = notification.type();
        Optional.ofNullable(handlers.get(identifier))
                .ifPresent(handler -> {
                    boolean contentValid = contentFilter.entrySet().stream()
                            .allMatch(entry -> entry.getKey().test(notification));

                    if (contentValid) {
                        handler.accept(notification);
                    } else {
                        System.out.println("Notification rejected due to inappropriate content: " + notification.message());
                    }
                });
    }
}
