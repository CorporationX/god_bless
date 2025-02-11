package school.faang.metauniverse;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private static final Set<String> OBSCENE_LANGUAGE = Set.of("WTF", "Shitcode", "Refucktoring", "Heisenbug");
    private static final String COMPANY_NAME = "Faang School";

    private final Map<NotificationType, Consumer<Notification>> notificationTypes = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationTypes.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (checkObscene(notification)) {
            notificationTypes.computeIfPresent(notification.notificationType(), (notificationType, consumer) -> {
                consumer.accept(addCompanyName(notification));
                return consumer;
            });
        }
    }

    private boolean checkObscene(Notification notification) {
        Predicate<String> isObscene = OBSCENE_LANGUAGE::contains;

        return Arrays.stream(notification.message().split(" ")).noneMatch(isObscene);
    }

    private Notification addCompanyName(Notification notification) {
        Function<Notification, Notification> companyNameNotif = notif ->
                new Notification(notif.notificationType(), COMPANY_NAME + " " + notif.message());

        return companyNameNotif.apply(notification);
    }
}
