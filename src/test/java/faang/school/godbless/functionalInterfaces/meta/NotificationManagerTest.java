package faang.school.godbless.functionalInterfaces.meta;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class NotificationManagerTest {
    NotificationManager notificationManager = new NotificationManager();

    @Test
    void testRegisterHandlerValidParamsRegisterHandler() {
        //given
        var notificationType = "email";
        Function<Notification, String> notificationHandler = notification -> "Send the \""
                + notification.message()
                + "\" notification via email.";


        //when
        var registrationStatus = notificationManager.registerHandler(notificationType, notificationHandler);


        //then
        assertTrue(registrationStatus);
    }

    @Test
    void testRegisterHandlerInvalidParamsRegistrationFails() {
        //given
        var blankNT = ""; //NT = NotificationType
        var validNT = "email";
        Function<Notification, String> notificationHandler = notification -> "Send the \""
                + notification.message()
                + "\" notification via email.";


        //when
        var blankNTRegistrationStatus = notificationManager.registerHandler(blankNT, notificationHandler);
        var nullNTRegistrationStatus = notificationManager.registerHandler(null, notificationHandler);
        var nullHandlerRegistrationStatus = notificationManager.registerHandler(validNT, null);

        //then
        assertFalse(blankNTRegistrationStatus);
        assertFalse(nullNTRegistrationStatus);
        assertFalse(nullHandlerRegistrationStatus);
    }

    @Test
    void testSendNotificationValidNotificationReturnsNotificationHandling() {
        //given
        var emailNotification = new Notification("email",
                "We are ready to make you an offer to junior Java developer position!");

        var expectedNotificationHandling = "Send the \""
                + emailNotification.message()
                + "\" notification via email.";

        var notificationType = "email";
        Function<Notification, String> notificationHandler = notification -> "Send the \""
                + notification.message()
                + "\" notification via email.";

        //when
        notificationManager.registerHandler(notificationType, notificationHandler);
        var actualNotificationHandling = notificationManager.sendNotification(emailNotification);

        //then
        assertNotNull(actualNotificationHandling);
        assertEquals(expectedNotificationHandling, actualNotificationHandling);
    }

    @Test
    void testSendNotificationInvalidNotificationThrowsException() {
        //given
        var nullValuedNotificationExceptionMessage = "Null-valued notification cannot be processed";
        var foreignNotificationTypeExceptionMessage = "No such notification type in system!";

        var foreignTypeNotification = new Notification("pigeon",
                "We are ready to make you an offer to junior Java developer position!");


        //when
        Exception nullValuedNotificationException = assertThrows(IllegalArgumentException.class, () -> {
            notificationManager.sendNotification(null);
        });

        Exception foreignNotificationTypeException = assertThrows(NoSuchElementException.class, () -> {
            notificationManager.sendNotification(foreignTypeNotification);
        });


        //then
        assertEquals(nullValuedNotificationExceptionMessage, nullValuedNotificationException.getMessage());
        assertEquals(foreignNotificationTypeExceptionMessage, foreignNotificationTypeException.getMessage());
    }
}