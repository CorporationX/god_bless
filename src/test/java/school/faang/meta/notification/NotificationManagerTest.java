package school.faang.meta.notification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotificationManagerTest {
    private NotificationManager manager;

    @BeforeEach
    public void setUp() {
        manager = new NotificationManager();
    }

    @Test
    public void testRegisterDuplicateHandler() {
        Consumer<Notification> emailHandler = notification -> System.out.println("Email: " + notification.getMessage());
        boolean emailRegistered = manager.registerHandler(NotificationType.EMAIL, emailHandler);
        boolean secondEmailRegistered = manager.registerHandler(NotificationType.EMAIL, emailHandler);
        assertTrue(emailRegistered);
        assertFalse(secondEmailRegistered);
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    public void testSendNotification(NotificationType type, Consumer<Notification> handler, Notification notification) {
        manager.registerHandler(type, handler);
        boolean sent = manager.sendNotification(notification);
        assertTrue(sent);
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    public void testSendNotificationWithFilter(NotificationType type,
                                               Consumer<Notification> handler, Notification notification) {
        Predicate<Notification> filter = (notif) -> {
            if (notif.getType().equals(NotificationType.EMAIL)) {
                return false;
            }

            return true;
        };
        manager.registerHandler(type, handler);
        boolean sent = manager.sendNotification(notification, filter);
        if (type.equals(NotificationType.EMAIL)) {
            assertFalse(sent);
            return;
        }

        assertTrue(sent);
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    public void testSendNotificationWithProcessing(NotificationType type, Consumer<Notification> handler,
                                                   Notification notification) {
        Function<Notification, Notification> processor = (notif) -> {
            String message = notif.getMessage().concat("\nSent from Intellij IDEA Community edition");
            Notification processedNotification = new Notification(notif.getType(), message);
            return processedNotification;
        };

        manager.registerHandler(type, handler);
        boolean sent = manager.sendNotification(notification, processor);
        assertTrue(sent);
    }

    private static Stream<Arguments> provideParameters() {
        var handler = new Consumer<Notification>() {
            @Override
            public void accept(Notification notification) {
                System.out.printf("%s: %s\n", notification.getType(), notification.getMessage());
            }
        };

        return Stream.of(
                Arguments.of(NotificationType.EMAIL, handler,
                        new Notification(NotificationType.EMAIL, "Your account is activated")),
                Arguments.of(NotificationType.SMS, handler,
                        new Notification(NotificationType.SMS, "You password has been successfully changed")),
                Arguments.of(NotificationType.PUSH, handler,
                        new Notification(NotificationType.PUSH, "You have a new message!"))
        );
    }
}
