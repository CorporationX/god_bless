package meta_universe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManagerTest {
    private NotificationManager notificationManager;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        notificationManager = new NotificationManager();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testRegisterHandler() {
        Consumer<Notification> handler = (notification) -> System.out.println("Handler called");

        notificationManager.registerHandler("email", handler);

        Assertions.assertEquals(handler, notificationManager.getHandlers().get("email"));
    }

    @Test
    void testRegisterContentFilter() {
        Predicate<Notification> filter = (notification) -> notification.message().contains("spam");
        Consumer<Notification> action = (notification) -> System.out.println("Filter action called");

        notificationManager.registerContentFilter(filter, action);

        Assertions.assertEquals(action, notificationManager.getContentFilter().get(filter));
    }

    @Test
    void testSendNotificationWithValidContent() {
        Consumer<Notification> handler = (notification) -> System.out.print("Handler called");
        notificationManager.registerHandler("email", handler);

        Notification notification = new Notification("email", "Valid content");
        notificationManager.sendNotification(notification);

        Assertions.assertEquals("Handler called", outputStream.toString());
    }
}
