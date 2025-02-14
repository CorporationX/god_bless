package school.faang.meta_universe.BJS2_57812;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NotificationManagerTest {
    NotificationManager notificationManager;

    Notification email;
    Notification sms;
    Notification push;
    List<String> forbiddenWords;

    @BeforeEach
    void setUp() {
        forbiddenWords = List.of("planet");

        notificationManager = new NotificationManager(forbiddenWords);

        email = new Notification(
                NotificationType.EMAIL, "Luke, I'm your father.");
        sms = new Notification(
                NotificationType.SMS, "Luke, I'm your father. Get over it.");
        push = new Notification(
                NotificationType.PUSH, "Luke, I know what planet to look for you on.");

    }

    @Test
    void testRegisterHandler() {
        notificationManager.registerHandler(
                NotificationType.EMAIL, (email) -> System.out.println("EMAIL: " + email.message()));
        notificationManager.registerHandler(
                NotificationType.SMS, (sms) -> System.out.println("SMS: " + sms.message()));
        notificationManager.registerHandler(
                NotificationType.PUSH, (push) -> System.out.println("PUSH: " + push.message()));

        assertTrue(notificationManager.getHandlerDatabase().containsKey(NotificationType.EMAIL));
        assertTrue(notificationManager.getHandlerDatabase().containsKey(NotificationType.SMS));
        assertTrue(notificationManager.getHandlerDatabase().containsKey(NotificationType.PUSH));
    }

    @Test
    void testSendNotification() {
        notificationManager.registerHandler(
                NotificationType.EMAIL, (email) -> System.out.println(email.message()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        notificationManager.sendNotification(email);

        System.setOut(originalOut);

        String actualOutput = outputStream.toString().trim();
        assertThat(actualOutput).isEqualTo(email.message());
    }

    @Test
    void testSendNotificationWithoutHandler() {
        assertThrows(NullPointerException.class, () -> {
            notificationManager.sendNotification(push);
        });
    }

    @Test
    void testFiltering() {
        assertTrue(notificationManager.filtering(sms.message()));
        assertFalse(notificationManager.filtering(push.message()));
    }

    @Test
    void testAddSender() {
        Notification notification = new Notification(
                NotificationType.PUSH, "Luke, I know what planet to look for you on.");

        notification = notificationManager.addSender(notification, "your favourite daddy");

        notificationManager.registerHandler(
                NotificationType.PUSH, push -> System.out.println(push.message()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        notificationManager.sendNotification(notification);

        System.setOut(originalOut);

        String actualOutput = outputStream.toString().trim();
        assertThat(actualOutput).isEqualTo(notification.message());
    }
}