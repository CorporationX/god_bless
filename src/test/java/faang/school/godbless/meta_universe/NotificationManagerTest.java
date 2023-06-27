package faang.school.godbless.meta_universe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class NotificationManagerTest {
    Notification emailNotification;
    Notification smsNotification;
    Notification pushNotification;

    @BeforeEach
    void setIp() {
        emailNotification = new Notification("email", "Verify your email");
        smsNotification = new Notification("sms", "You have successfully changed your password");
        pushNotification = new Notification("qwe", "New post from JohnDoe - Fuck this...");
    }

    @Test
    void sendNotification() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

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

    @Test
    void testFilterNotification() {
        Predicate<Notification> containsObsceneContent =
                notification -> notification.getMessage().toLowerCase().contains("fuck");
        Function<Notification, Notification> filterObsceneContent =
                notification -> new Notification(notification.getType(), "Message contains obscene content");
        NotificationManager.registerFilter(containsObsceneContent, filterObsceneContent);

        Notification filteredNotification = NotificationManager.filterNotification(pushNotification);

        assertEquals("Message contains obscene content", filteredNotification.getMessage());
    }
}