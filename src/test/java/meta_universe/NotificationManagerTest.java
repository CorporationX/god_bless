package meta_universe;

import faang.school.godbless.meta_universe.Notification;
import faang.school.godbless.meta_universe.NotificationManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class NotificationManagerTest {

    NotificationManager notificationManager = new NotificationManager();

    @Test
    @DisplayName("Email notification test")
    void shouldSendEmailNotification() {
        notificationManager.registerHandler("email",
                (notification) -> System.out.print("Sending e-mail: " + notification.getMessage()));

        Notification emailNotification = new Notification("email",
                "Congratulations - You've been selected by Apple");

        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));

        notificationManager.sendNotification(emailNotification);

        String testEmailNotification = "Sending e-mail: Congratulations - You've been selected by Apple";

        Assertions.assertEquals(testEmailNotification, actualOutput.toString());
    }

    @Test
    @DisplayName("SMS notification test")
    void shouldSendSMSNotification() {
        notificationManager.registerHandler("sms",
                (notification) -> System.out.print("Sending SMS: " + notification.getMessage()));

        Notification smsNotification = new Notification("sms",
                "123456 is your Facebook confirmation code");

        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));

        notificationManager.sendNotification(smsNotification);

        String testSMSNotification = "Sending SMS: 123456 is your Facebook confirmation code";

        Assertions.assertEquals(testSMSNotification, actualOutput.toString());
    }

    @Test
    @DisplayName("Push notification test")
    void shouldSendPushNotification() {

        notificationManager.registerHandler("push",
                (notification) -> System.out.print("Sending push-notification: " + notification.getMessage()));

        Notification pushNotification = new Notification("push",
                "faang.school recently shared new reels");

        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));

        notificationManager.sendNotification(pushNotification);

        String testPushNotification = "Sending push-notification: faang.school recently shared new reels";

        Assertions.assertEquals(testPushNotification, actualOutput.toString());
    }
}
