package faang.school.godbless.task_18_meta_universe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotificationManagerTest {
    private final NotificationManager manager = new NotificationManager();
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testRegisteHandler() {
        // Arrange
        String type = "notificationType";
        String message = "notificationMessage";
        Notification notification = new Notification(type, message);

        String consumerText = "ConcumerText:";
        Consumer<Notification> consumer = n -> System.out.printf("%s %s%n", consumerText, n.message());

        String expectation = "%s %s".formatted(consumerText, message);

        // Act
        manager.registerHandler(type, consumer);

        // Assert
        assertTrue(manager.notificationMap.containsKey(type), "тип нотификации отсутствует в Map");

        // Act
        manager.notificationMap.get(type).accept(notification);

        // Assert
        assertEquals(expectation, outputStreamCaptor.toString().trim(), "не соответствуют оповещения");
    }

    @Test
    public void testSendNotification() {
        // Arrange
        String type = "notificationType";
        String message = "notificationMessage";
        Notification notification = new Notification(type, message);

        String consumerText = "ConcumerText:";
        Consumer<Notification> consumer = n -> System.out.printf("%s %s%n", consumerText, n.message());
        manager.registerHandler(type, consumer);

        String expectation = "%s %s".formatted(consumerText, message);

        // Act
        manager.sendNotification(notification);

        // Assert
        assertEquals(expectation, outputStreamCaptor.toString().trim(), "не соответствуют оповещения");
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
