package school.faang.bjs2_70670;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {

    private final Map<NotificationType, Consumer<Notification>> prefixHandlers = new HashMap<>();
    private final Map<NotificationType, Predicate<Notification>> typeCheckHandlers = new HashMap<>();
    private final Map<String, Function<Notification, Notification>> signatureHandlers = new HashMap<>();
    private final Map<NotificationType,
            BiFunction<Notification, Predicate<Notification>, Notification>>
            exceptionHandlers = new HashMap<>();

    public void registerPrefixHandlers(NotificationType type, Consumer<Notification> handler) {
        prefixHandlers.put(type, handler);
    }

    public void registerTypeCheckHandlers(NotificationType type, Predicate<Notification> typeCheck) {
        typeCheckHandlers.put(type, typeCheck);
    }

    public void registerSignatureHandlers(String signature, Function<Notification, Notification> signatureHandler) {
        signatureHandlers.put(signature, signatureHandler);
    }

    public void registerExceptionHandlers(NotificationType type,
                                          BiFunction<Notification, Predicate<Notification>, Notification> exception) {
        exceptionHandlers.put(type, exception);
    }

    public void sendNotification(Notification notification, String signature) {
        Function<Notification, Notification> signatureHandler = signatureHandlers.get(signature);
        if (signatureHandler != null) {
            notification = signatureHandler.apply(notification);
        } else {
            System.out.println("No proper signature found");
        }

        BiFunction<Notification,
                Predicate<Notification>,
                Notification> exceptionHandler = exceptionHandlers.get(notification.getType());

        if (exceptionHandler != null) {
            Predicate<Notification> typeCheck = typeCheckHandlers.get(notification.getType());
            if (typeCheck != null) {
                notification = exceptionHandler.apply(notification, typeCheck);
            }
        }

        Consumer<Notification> notificationConsumer = prefixHandlers.get(notification.getType());
        if (notificationConsumer != null) {
            notificationConsumer.accept(notification);
        } else {
            System.out.println("No proper prefix found");
        }
    }
}
