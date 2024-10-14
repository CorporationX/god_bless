package school.faang.bjs2_34897;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.fail;

public class NotificationManagerTest {

    private NotificationManager manager;

    @BeforeEach
    public void setUp() {
        manager = new NotificationManager();
    }

    @Test
    public void testRegisterHandlerAndSendNotification() {
        Notification emailNotification = new Notification("Email", "Welcome to our service!");

        manager.registerHandler("Email", (notification) -> {
            assertThat(notification.getMessage(), is("Welcome to our service!"));
        });

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        manager.sendNotification(emailNotification);

        assertThat(outContent.toString(), containsString("Welcome to our service!"));

        System.setOut(System.out);
    }

    @Test
    public void testContentFilter() {
        Notification spamNotification = new Notification("Email", "This is spam, ignore it.");

        manager.registerHandler("Email", (notification) -> {
            fail("This notification should be blocked by the filter");
        });

        manager.registerContentFilter((notification) -> {
            return !notification.getMessage().toLowerCase().contains("spam");
        });

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        manager.sendNotification(spamNotification);

        assertThat(outContent.toString(), containsString("Notification blocked"));

        System.setOut(System.out);
    }

    @Test
    public void testContentTransformer() {
        Notification urgentNotification = new Notification("Push", "This is an urgent message.");

        manager.registerHandler("Push", (notification) -> {
            assertThat(notification.getMessage(), is("This is an important message."));
        });

        manager.registerContentTransformer((notification) -> {
            String modifiedMessage = notification.getMessage().replace("urgent", "important");
            return new Notification(notification.getType(), modifiedMessage);
        });

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        manager.sendNotification(urgentNotification);

        assertThat(outContent.toString(), containsString("important message"));

        System.setOut(System.out);
    }

    @Test
    public void testUnregisteredNotificationHandler() {
        Notification unregisteredNotification = new Notification("Unknown", "No handler for this");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        manager.sendNotification(unregisteredNotification);

        assertThat(outContent.toString(), containsString("No one found"));

        System.setOut(System.out);
    }
}
