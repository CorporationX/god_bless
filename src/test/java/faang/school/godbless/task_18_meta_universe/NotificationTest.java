package faang.school.godbless.task_18_meta_universe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotificationTest {
    @Test
    public void testInit(){
        // Arrange
        String type = "some type";
        String message = "some message";

        // Action
        Notification notification = new Notification(type, message);

        // Assert
        assertEquals(type, notification.type(), "поле type не совпадает.");
        assertEquals(message, notification.message(), "поле message не совпадают.");
    }
}
