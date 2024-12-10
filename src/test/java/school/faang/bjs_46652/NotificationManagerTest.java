package school.faang.bjs_46652;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

class NotificationManagerTest {
    private final NotificationManager manager = new NotificationManager();

    @ParameterizedTest
    @MethodSource("registerParameters")
    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        List<String> beforeRegister = manager.getRegisteredHandlers();
        manager.registerHandler(notificationType, handler);
        List<String> afterRegister = manager.getRegisteredHandlers();
        Assertions.assertTrue(afterRegister.containsAll(beforeRegister));
        Assertions.assertEquals(afterRegister.size(), beforeRegister.size() + 1);
    }

    @ParameterizedTest
    @MethodSource("getNotifications")
    public void sendNotification(Notification notification) {
        registerDefaultHandlers();
        boolean actual = manager.sendNotification(notification);
        Assertions.assertTrue(actual);
    }

    public static Stream<Arguments> registerParameters() {
        return Stream.of(
                Arguments.of(
                        "email", (Consumer<Notification>) (notification) -> {
                            System.out.println("Отправка по электронной почте: " + notification.getMessage());
                        }),
                Arguments.of(
                        "sms", (Consumer<Notification>) (notification) -> {
                            System.out.println("Отправка SMS: " + notification.getMessage());
                        }),
                Arguments.of(
                        "push", (Consumer<Notification>) (notification) -> {
                            System.out.println("Отправка push-уведомления: " + notification.getMessage());
                        }));
    }

    public static Stream<Arguments> getNotifications() {
        return Stream.of(
                Arguments.of(
                        new Notification(NotificationType.valueOf("email".toUpperCase()),
                                "Ваша учетная запись успешно активирована")
                ),
                Arguments.of(
                        new Notification(NotificationType.valueOf("sms".toUpperCase()),
                                "Вы успешно изменили свой пароль")
                ),
                Arguments.of(
                        new Notification(NotificationType.valueOf("push".toUpperCase()),
                                "Новый пост от пользователя: JohnDoe")
                )

        );
    }

    private void registerDefaultHandlers() {
        manager.unregisterAllHandlers();
        manager.registerHandler("email",
                (notification) -> System.out.println("Отправка по электронной почте: "
                        + notification.getMessage())
        );

        manager.registerHandler("sms",
                (notification) -> System.out.println("Отправка SMS: "
                        + notification.getMessage())
        );

        manager.registerHandler("push",
                (notification) -> System.out.println("Отправка push-уведомления: "
                        + notification.getMessage())
        );
    }
}