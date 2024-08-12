package faang.school.godbless.secondsprint.metauniverse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotificationManagerTest {
    private NotificationManager notificationManager;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @BeforeEach
    public void setUp() {
        notificationManager = new NotificationManager();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Should correctly handle notifications of different types")
    public void testDifferentNotificationTypes() {
        notificationManager.registerHandler("email", (notification) ->
                System.out.println("Email notification: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) ->
                System.out.println("SMS notification: " + notification.getMessage()));

        Notification emailNotification = new Notification("email", "You've got mail");
        Notification smsNotification = new Notification("sms", "New message");

        notificationManager.sendNotification(emailNotification);
        String emailOutput = outputStreamCaptor.toString().trim();
        outputStreamCaptor.reset();

        notificationManager.sendNotification(smsNotification);
        String smsOutput = outputStreamCaptor.toString().trim();

        assertAll(
                () -> assertEquals("Email notification: You've got mail", emailOutput),
                () -> assertEquals("SMS notification: New message", smsOutput)
        );
    }

    @Test
    @DisplayName("Should handle notification when no handler is registered")
    public void testSendNotificationNoHandler() {
        Notification notification = new Notification("unknown", "Test message");
        notificationManager.sendNotification(notification);

        String expectedMessage = "A handler for 'unknown' notification type was not found.";
        String output = outputStreamCaptor.toString().trim();
        assertEquals(expectedMessage, output);
    }
}
