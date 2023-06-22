package faang.school.godbless.sprint3.meta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class NotificationManagerTest {
    private NotificationManager notificationManager;

    @BeforeEach
    void setNotificationManagerAndFillHandlerMap() {
        notificationManager = new NotificationManager();

        notificationManager.registerHandler(
                "email",
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage())
        );
        notificationManager.registerHandler(
                "sms",
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
        );
        notificationManager.registerHandler(
                "push",
                (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage())
        );

        notificationManager.registerFilter("email", message -> message.contains("password"));
    }

    @Test
    void registerHandler_handlerMapShouldBeFilled() {
        assertAll(() -> {
            assertEquals(notificationManager.getHandlerMap().size(), 3);
            assertTrue(notificationManager.getHandlerMap().containsKey("email"));
            assertTrue(notificationManager.getHandlerMap().containsKey("sms"));
            assertTrue(notificationManager.getHandlerMap().containsKey("push"));
        });
    }

    @Test
    void registerFilter() {
        assertEquals(notificationManager.getHandlerMap().size(), 1);
        assertTrue(notificationManager.getHandlerMap().containsKey("email"));
    }

    @ParameterizedTest
    @MethodSource("getParams")
    void sendNotification_shouldMatchWithOutput(Notification notification, String expectedMessage) {
        PrintStream console = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        notificationManager.sendNotification(notification);

        System.setOut(console);

        assertEquals(expectedMessage, output.toString().trim());
    }

    static Stream<Arguments> getParams() {
        return Stream.of(
                Arguments.of(
                        new Notification("email", "Ваша учетная запись успешно активирована"),
                        "Отправка по электронной почте: Ваша учетная запись успешно активирована"
                ),
                Arguments.of(
                        new Notification("sms", "Вы успешно изменили свой пароль"),
                        "Отправка SMS: Вы успешно изменили свой пароль"
                ),
                Arguments.of(
                        new Notification("push", "Новый пост от пользователя: JohnDoe"),
                        "Отправка push-уведомления: Новый пост от пользователя: JohnDoe"
                )
        );
    }

    @Test
    void filter_shouldChangeNotificationMessage() {
        // ничего интереснее в голову не пришло..)
        Notification notification = new Notification("email", "Your new password: 123456788");
        notificationManager.filter(
                notification,
                n -> "Уведомление содержит пароль, откройте приложение для просмотра"
        );

        assertEquals(
                "Уведомление содержит пароль, откройте приложение для просмотра",
                notification.getMessage()
        );
    }
}