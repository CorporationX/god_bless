package school.faang.bjs2_34897;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.function.Consumer;
public class NotificationManagerTest {

    @BeforeEach
    public void setUp() {
        // Clear the handlers and filters before each test
        NotificationManager.clearHandlers();
        NotificationManager.clearFiltersAndTransformers();
    }

    // Test registering handlers and sending notifications
    @Test
    public void testRegisterHandlerAndSendNotification() {
        Notification emailNotification = new Notification("Email", "Welcome to our service!");

        // Register a handler for "Email"
        NotificationManager.registerHandler("Email", (notification) -> {
            assertEquals("Welcome to our service!", notification.getMessage());
            System.out.println("Sending email: " + notification.getMessage());
        });

        // Send email notification and trigger the handler
        NotificationManager.sendNotification(emailNotification);
    }

    // Test content filtering
    @Test
    public void testContentFilter() {
        Notification spamNotification = new Notification("Email", "This is spam, ignore it.");

        // Register a handler
        NotificationManager.registerHandler("Email", (notification) -> {
            fail("This notification should be blocked by the filter");
        });

        // Register a content filter to block spam
        NotificationManager.registerContentFilter((notification) -> {
            return !notification.getMessage().toLowerCase().contains("spam");
        });

        // Send spam notification, should be blocked
        NotificationManager.sendNotification(spamNotification);
    }

    // Test content transformation
    @Test
    public void testContentTransformer() {
        Notification urgentNotification = new Notification("Push", "This is an urgent message.");

        // Register a handler for "Push"
        NotificationManager.registerHandler("Push", (notification) -> {
            assertEquals("This is an important message.", notification.getMessage());
            System.out.println("Send push notification: " + notification.getMessage());
        });

        // Register content transformer to replace "urgent" with "important"
        NotificationManager.registerContentTransformer((notification) -> {
            String modifiedMessage = notification.getMessage().replace("urgent", "important");
            return new Notification(notification.getType(), modifiedMessage);
        });

        // Send push notification, should be transformed
        NotificationManager.sendNotification(urgentNotification);
    }

    // Test handler for an unregistered notification type
    @Test
    public void testUnregisteredNotificationHandler() {
        Notification unregisteredNotification = new Notification("Unknown", "No handler for this");

        // Expecting no handler to be found for "Unknown"
        NotificationManager.sendNotification(unregisteredNotification);
        // No exception thrown and no output expected for unregistered type
    }
}