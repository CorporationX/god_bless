package school.faang.stream2.metauniverse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> configMap;
    private final Function<Notification, Notification> addSignature =
            n -> new Notification(n.getType(), n.getMessage() + "\nYours META.");
    private final Predicate<Notification> rudeBlocker =
            n -> RUDEWORDSDICT.stream().anyMatch(rude -> n.getMessage().toLowerCase().contains(rude));

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        configMap.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (!rudeBlocker.test(notification)) {
            Notification signedNotification = addSignature.apply(notification);
            configMap.getOrDefault(notification.getType(),
                    n -> System.err.printf("Unregistered notification type '%s' request with message: %s\n",
                            n.getType(), n.getMessage()))
                    .accept(signedNotification);
        }
    }

    public NotificationManager() {
        this.configMap = new HashMap<>();
    }

    private static final List<String> RUDEWORDSDICT = List.of("бля", "eба", "ёба", "хуё", "хуй", "пизд", "ёб");
}
