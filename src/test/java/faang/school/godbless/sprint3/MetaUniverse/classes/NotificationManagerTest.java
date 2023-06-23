package faang.school.godbless.sprint3.MetaUniverse.classes;

import faang.school.godbless.sprint3.lambdas.MetaUniverse.Notification;
import faang.school.godbless.sprint3.lambdas.MetaUniverse.NotificationManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

class NotificationManagerTest {

    private static final String EMAIL_NOTIFICATION = "Отправка сообщений по email: ";

    private static final String SMS_NOTIFICATION = "Отправка SMS сообщений: ";

    private static final String PUSH_NOTIFICATION = "Отправка push-уведомления: ";

    private static NotificationManager notificationManager;

    private static ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeAll
    public static void setUp() {
        notificationManager = new NotificationManager();
        notificationManager.registerHandler("email", notification -> System.out.println(EMAIL_NOTIFICATION + notification.getMessage()));
        notificationManager.registerHandler("sms", notification -> System.out.println(SMS_NOTIFICATION + notification.getMessage()));
        notificationManager.registerHandler("push", notification -> System.out.println(PUSH_NOTIFICATION + notification.getMessage()));

    }

    @BeforeAll
    public static void setUpStream() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("Map contains correct key")
    void notificationManager_ContainsCorrectKey() {
        Assertions.assertAll(
                () -> Assertions.assertTrue(notificationManager.getNotificationMap().containsKey("email")),
                () -> Assertions.assertTrue(notificationManager.getNotificationMap().containsKey("sms")),
                () -> Assertions.assertTrue(notificationManager.getNotificationMap().containsKey("push"))
        );
    }

    @ParameterizedTest
    @MethodSource("getNotifications")
    @DisplayName("Map send correct notification answer test")
    void sendNotification_correctAnswer(String expected, Notification notification) {
        notificationManager.sendNotification(notification);
        Assertions.assertEquals(expected, outputStream.toString());
    }

    @Test
    @DisplayName("Test with null")
    void sendNotification_testWithNull(){
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> notificationManager.sendNotification(null));
        Assertions.assertEquals(NotificationManager.NOTIFICATION_IS_NULL_MESSAGE, exception.getMessage());
    }


    private static Stream<Arguments> getNotifications() {
        return Stream.of(
                Arguments.of(EMAIL_NOTIFICATION + "Новое сообщение от Яндекса\n", new Notification("email", "Новое сообщение от Яндекса")),
                Arguments.of(SMS_NOTIFICATION + "Ваш СМС-код: 123-456\n", new Notification("sms", "Ваш СМС-код: 123-456")),
                Arguments.of(PUSH_NOTIFICATION + "Кто то пытается зайти ваш аккаунт с друого устройства\n", new Notification("push", "Кто то пытается зайти ваш аккаунт с друого устройства"))
        );
    }

    @AfterEach
    public void resetStream() {
        outputStream.reset();
    }

    @AfterAll
    public static void cleanUpStream() {
        System.setOut(null);
    }
}