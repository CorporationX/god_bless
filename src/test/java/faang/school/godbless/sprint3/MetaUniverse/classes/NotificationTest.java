package faang.school.godbless.sprint3.MetaUniverse.classes;

import faang.school.godbless.sprint3.lambdas.MetaUniverse.Notification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificationTest {
    private static Notification notification;

    @BeforeAll
    public static void setUp(){
        notification = new Notification("sms", "something");
    }

    @Test
    void isNull_test(){
        assertTrue(Notification.isNull(null));
        assertFalse(Notification.isNull(notification));
    }

}