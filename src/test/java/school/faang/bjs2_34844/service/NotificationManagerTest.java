package school.faang.bjs2_34844.service;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

class NotificationManagerTest {
    private final NotificationManager notificationManager = new NotificationManager();

    @Test
    void registerHandler() {
        TypeNotification push = TypeNotification.PUSH;
        Consumer<Notification> consumer = notification -> System.out.println(TypeNotification.PUSH.getActionMessage() + notification.getMessage());

        IllegalArgumentException illegalArgumentExceptionTypeNull = assertThrows(IllegalArgumentException.class,
                () -> notificationManager.registerHandler(null, consumer));
        assertEquals(ErrMessagesValidate.TYPE_NOTIFICATION_IS_NULL, illegalArgumentExceptionTypeNull.getMessage());

        IllegalArgumentException illegalArgumentExceptionHandlerNull = assertThrows(IllegalArgumentException.class,
                () -> notificationManager.registerHandler(push, null));
        assertEquals(ErrMessagesValidate.HANDLER_IS_NULL, illegalArgumentExceptionHandlerNull.getMessage());

        notificationManager.registerHandler(push, consumer);

        Map<TypeNotification, Consumer<Notification>> notificationIDsWithTheirHandlers = notificationManager.getNotificationIDsWithTheirHandlers();
        assertTrue(notificationIDsWithTheirHandlers.containsKey(push));

        Consumer<Notification> consumerForMap = notificationIDsWithTheirHandlers.get(push);
        assertEquals(consumer, consumerForMap);
        notificationIDsWithTheirHandlers.clear();
    }

    @Test
    void sendNotification() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> notificationManager.sendNotification(null));
        assertEquals(ErrMessagesValidate.NOTIFICATION_IS_NULL, illegalArgumentException.getMessage());

        Notification notificationTypeNull = new Notification(null, "Your order has been successfully placed");
        NoSuchElementException noSuchElementException = assertThrows(NoSuchElementException.class, () -> notificationManager.sendNotification(notificationTypeNull));
        assertEquals(ErrMessagesValidate.TYPE_NOTIFICATION_IS_NULL, noSuchElementException.getMessage());


        TypeNotification typeNotificationForRegister = TypeNotification.EMAIL;
        String checkedString = "Test";
        Consumer<Notification> handlerForRegister = notification -> notification.setMessage(checkedString);
        notificationManager.registerHandler(typeNotificationForRegister, handlerForRegister);

        Notification emailNotification = new Notification(TypeNotification.EMAIL, "Your order has been successfully placed");
        notificationManager.sendNotification(emailNotification);
        assertEquals(checkedString,emailNotification.getMessage());

    }
}