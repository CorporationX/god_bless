package faang.school.godbless.meta_universe;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class NotificationManagerTest {

    @Test
    void sendNotification() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        Notification emailNotification = new Notification("email", "Verify your email");
        Notification smsNotification = new Notification("sms", "You have successfully changed your password");
        Notification pushNotification = new Notification("push", "New post from JohnDoe");
        NotificationManager.registerHandler("email",
                (notification) -> System.out.println("Sending by email: " + notification.getMessage()));
        NotificationManager.registerHandler("sms",
                (notification) -> System.out.println("Sending SMS: " + notification.getMessage()));
        NotificationManager.registerHandler("push",
                (notification) -> System.out.println("Sending push-notification: " + notification.getMessage()));

        NotificationManager.sendNotification(emailNotification);
        NotificationManager.sendNotification(smsNotification);
        NotificationManager.sendNotification(pushNotification);
        assertTrue(outputStream.toString().contains("Verify your email"));
        assertTrue(outputStream.toString().contains("You have successfully changed your password"));
        assertTrue(outputStream.toString().contains("New post from JohnDoe"));
    }
}