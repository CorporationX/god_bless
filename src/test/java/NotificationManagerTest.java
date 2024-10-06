import org.junit.jupiter.api.Test;
import school.faang.meta.Notification;
import school.faang.meta.NotificationManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NotificationManagerTest {
    private static final NotificationManager manager = new NotificationManager();

    @Test
    public void testIfThrowsExceptionWhenHandlerNull() {
        // arrange
        manager.registerHandler("email",
                (notification) -> System.out.println("Sending an email: " + notification.getMessage())
        );
        Notification passwordNotification = new Notification("pass", "Password change approved");

        // assert
        assertThrows(IllegalArgumentException.class, () -> manager.sendNotification(passwordNotification));
    }

    @Test
    public void testFilterWithCorrections() {
        // arrange
        manager.registerFilter("email", (notification) -> {
            String message = notification.getMessage();
            message = message.replaceAll("fuck", "*****");
            return new Notification(notification.getType(), message);
        });
        Notification emailNotification = new Notification("email", "Go fuck yourself!");
        String expected = "Go ***** yourself!";

        // assert
        manager.registerHandler("email", (notification) ->
                assertEquals(expected, notification.getMessage(), "Should return message with filtered text")
        );
        manager.sendNotification(emailNotification);
    }

    @Test
    public void testFilterWithoutCorrections() {
        // arrange
        manager.registerFilter("email", (notification) -> {
            String message = notification.getMessage();
            message = message.replaceAll("fuck", "*****");
            return new Notification(notification.getType(), message);
        });
        Notification emailNotification = new Notification("email", "Go clean yourself!");
        String expected = "Go clean yourself!";

        // assert
        manager.registerHandler("email", (notification) ->
                assertEquals(expected, notification.getMessage(), "Should return message with no filtered text")
        );
        manager.sendNotification(emailNotification);
    }

    @Test
    public void testIfWorksWithoutFilter() {
        // arrange
        Notification emailNotification = new Notification("email", "Go clean yourself!");
        String expected = "Go clean yourself!";

        // assert
        manager.registerHandler("email", (notification) ->
                assertEquals(expected, notification.getMessage(),
                        "Should just return the same message (no filter is registered")
        );
        manager.sendNotification(emailNotification);
    }

    @Test
    public void testMultipleNotifications() {
        // arrange
        Notification emailNotification = new Notification("email", "Go fuck yourself!");
        Notification passNotification = new Notification("password", "Password change approved.");

        manager.registerFilter("email", (notification) -> {
            String message = notification.getMessage();
            message = message.toLowerCase().replaceAll("fuck", "*****");
            return new Notification(notification.getType(), message);
        });
        manager.registerFilter("password", (notification) -> new Notification(notification.getType(),
                notification.getMessage() + " If you didn't change it, contact support."));
        String emailExpected = "go ***** yourself!";
        String passExpected = "Password change approved. If you didn't change it, contact support.";

        // assert
        manager.registerHandler("email",
                (notification) -> assertEquals(emailExpected, notification.getMessage(),
                        "Should return filtered text")
        );
        manager.registerHandler("password",
                (notification) -> assertEquals(passExpected, notification.getMessage(),
                        "Should return new text.")
        );
        manager.sendNotification(emailNotification);
        manager.sendNotification(passNotification);
    }
}
