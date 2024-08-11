package faang.school.godbless.meta_universe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.Map;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

class NotificationManagerTest {
    @Test
    void testRegisterHandler() {
        NotificationManager notificationManager = new NotificationManager();
        Consumer<Notification> notificationHandler = notificationManager::sendNotification;
        notificationManager.registerHandler("Type", notificationHandler);
        Map<String, Consumer<Notification>> stringConsumerMap = notificationManager.notificationHandlers;
        assertEquals(1, stringConsumerMap.size());
        assertSame(notificationHandler, stringConsumerMap.get("Type"));
    }
}
