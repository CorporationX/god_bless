package faang.school.godbless.functionalInterfaces.meta;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class NotificationManagerTest {
    NotificationManager notificationManager = new NotificationManager();

    @Test
    void testRegisterHandler_validParams_registerHandler() {
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
    void testRegisterHandler_invalidParams_registrationFails() {
        //given
        var blankNT = ""; //NT = NotificationType
        var validNT = "email";
        Function<Notification, String> notificationHandler = notification -> "Send the \""
                + notification.message()
                + "\" notification via email.";


        //when
        var blankNT_RegistrationStatus = notificationManager.registerHandler(blankNT, notificationHandler);
        var nullNT_RegistrationStatus = notificationManager.registerHandler(null, notificationHandler);
        var nullHandlerRegistrationStatus = notificationManager.registerHandler(validNT, null);

        //then
        assertFalse(blankNT_RegistrationStatus);
        assertFalse(nullNT_RegistrationStatus);
        assertFalse(nullHandlerRegistrationStatus);
    }

    @Test
    void testSendNotification_validNotification_returnsNotificationHandling() {
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
    void testSendNotification_invalidNotification_throwsException() {
        //given
        var expectedMessage = "Null-valued notification cannot be processed";

        //when
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            notificationManager.sendNotification(null);
        });


        //then
        assertEquals(expectedMessage, exception.getMessage());
    }
}