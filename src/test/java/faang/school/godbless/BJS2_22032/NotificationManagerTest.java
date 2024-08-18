package faang.school.godbless.BJS2_22032;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

class NotificationManagerTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private NotificationManager manager;
    private static final PrintStream ORIGINAL_OUT = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(ORIGINAL_OUT);
        manager = new NotificationManager();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void registerHandler() {
        manager.registerHandler("FILE_DOWNLOAD_COMPLETE",
                n -> System.out.println("FILE_DOWNLOAD_COMPLETE: " + n.getMessage()));

        assertThat(manager.getHandlers()).containsKeys("FILE_DOWNLOAD_COMPLETE").hasSize(7);
    }

    @Test
    void sendNotificationINFO() {
        String expectedMessage = "INFO: This is an informational message.";
        manager.sendNotification(new Notification("INFO", "This is an informational message."));

        assertThat(normalize(outputStreamCaptor.toString())).isEqualTo(expectedMessage);
        System.setOut(ORIGINAL_OUT);
        System.out.println(outputStreamCaptor);
    }

    @Test
    void sendNotificationERROR() {
        String expectedMessage = "ERROR: This is an error message.";
        manager.sendNotification(new Notification("ERROR", "This is an error message."));

        assertThat(normalize(outputStreamCaptor.toString())).isEqualTo(expectedMessage);
        System.setOut(ORIGINAL_OUT);
        System.out.println(outputStreamCaptor);
    }

    @Test
    void sendNotificationExtended() {
        String expectedMessage = "FRIEND_REQUEST: Anna has sent you a friend request" + " at " +
                DateTimeFormatter.ofPattern("HH:mm").format(LocalTime.now()) + ".";

        manager.registerHandler("FRIEND_REQUEST", n -> {
            if (n != null) {
                FriendsRequestNotification notification = (FriendsRequestNotification) n;
                System.out.println("FRIEND_REQUEST: " + notification.getFriendName() + " " + notification.getMessage()
                        + " at " + notification.getRequestTime() + ".");
            }
        });
        manager.sendNotification(new FriendsRequestNotification("has sent you a friend request",
                "Anna"));

        assertThat(normalize(outputStreamCaptor.toString())).isEqualTo(expectedMessage);
        System.out.flush();
        System.setOut(ORIGINAL_OUT);
        System.out.println(outputStreamCaptor);
    }

    private String normalize(String input) {
        return input.strip().replaceAll("\\s+", " ");
    }
}