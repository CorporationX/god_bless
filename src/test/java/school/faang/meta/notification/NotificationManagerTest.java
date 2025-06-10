package school.faang.meta.notification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Consumer;
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

    private static Stream<Arguments> provideParameters() {
        var handler = new Consumer<Notification>() {
            @Override
            public void accept(Notification notification) {
                System.out.printf("%s: %s\n", notification.getType(), notification.getMessage());
            }
        };

        return Stream.of(
                Arguments.of(NotificationType.EMAIL, handler, new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован")),
                Arguments.of(NotificationType.SMS, handler, new Notification(NotificationType.SMS, "Ваш пароль изменен")),
                Arguments.of(NotificationType.PUSH, handler, new Notification(NotificationType.PUSH, "У вас новое сообщение!"))
        );
    }
}
