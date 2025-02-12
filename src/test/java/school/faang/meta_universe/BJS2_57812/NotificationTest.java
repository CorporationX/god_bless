package school.faang.meta_universe.BJS2_57812;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificationTest {

    @Test
    void type() {
        assertThrows(NullPointerException.class, () -> {new Notification(null, "Yeyy!");});
    }

    @Test
    void message() {
        assertThrows(NullPointerException.class, () -> {new Notification(NotificationType.SMS, null);});
        assertThrows(IllegalArgumentException.class, () -> {new Notification(NotificationType.EMAIL, "");});
        assertThrows(IllegalArgumentException.class, () -> {new Notification(NotificationType.EMAIL, " ");});
    }
}