package faang.school.godbless.sprint3.Meta;

import faang.school.godbless.sprint3.Meta.Notification;
import faang.school.godbless.sprint3.Meta.NotificationManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MainTest {
    NotificationManager notificationManager = new NotificationManager();

    @Test
    void testRegisterHandlerEmail() {
        int lenOfMapUntilNotif = notificationManager.commands.size();
        notificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        assertEquals(lenOfMapUntilNotif + 1, notificationManager.commands.size());
    }

    @Test
    void testSendNotificationThrows() {
        NullPointerException res = assertThrows(NullPointerException.class, () -> notificationManager.sendNotification(new Notification("wrongType", "wrongMes")));
        assertEquals("this Type is not exist", res.getMessage());
    }
}