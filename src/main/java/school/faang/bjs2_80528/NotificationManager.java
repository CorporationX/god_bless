package school.faang.bjs2_80528;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Setter
@Slf4j
public class NotificationManager {
    private static final String COMPANY_SIGN = "Супер магазин";

    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();
    private List<String> illegalWords;

    private NotificationManager(NotificationManagerBuilder builder) {
        this.illegalWords = builder.illegalWords;
    }

    public static NotificationManagerBuilder builder() {
        return new NotificationManagerBuilder();
    }

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = handlers.get(notification.type());
        Predicate<String> predicate = word -> notification.massage().contains(word);
        Function<Notification, Notification> messageCorrection = oldNotification ->
                new Notification(oldNotification.type(), oldNotification.massage() + "\n - " + COMPANY_SIGN);

        if (handler != null) {
            if (containsIllegalWorlds(predicate)) {
                log.info("Обнаружено недопустимое слово");
            } else {
                Notification signedNotification = messageCorrection.apply(notification);
                handler.accept(signedNotification);
            }
        } else {
            log.info("Для типа {} нет обработчика", notification.type());
        }
    }

    private boolean containsIllegalWorlds(Predicate<String> predicate) {
        return illegalWords.stream().anyMatch(predicate);
    }

    static class NotificationManagerBuilder {
        private List<String> illegalWords = new ArrayList<>();

        public NotificationManagerBuilder withIllegalWords(List<String> illegalWords) {
            this.illegalWords = illegalWords;
            return this;
        }

        public NotificationManager build() {
            return new NotificationManager(this);
        }
    }
}
