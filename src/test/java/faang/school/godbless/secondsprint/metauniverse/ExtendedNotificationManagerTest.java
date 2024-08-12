package faang.school.godbless.secondsprint.metauniverse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExtendedNotificationManagerTest {
    private ExtendedNotificationManager extendedNotificationManager;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @BeforeEach
    public void setUp() {
        extendedNotificationManager = new ExtendedNotificationManager();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStreamCaptor));
        extendedNotificationManager.registerHandler("email", (notification) ->
                System.out.println("Email notification: " + notification.getMessage()));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Should apply filters and modifiers correctly to notifications")
    public void testFiltersAndModifiers() {
        Predicate<Notification> spamFilter = notification -> !notification.getMessage().contains("spam");
        Predicate<Notification> lengthFilter = notification -> notification.getMessage().length() > 10;
        extendedNotificationManager.registerFilter(spamFilter);
        extendedNotificationManager.registerFilter(lengthFilter);

        Function<Notification, Notification> toUpperCaseModifier = notification ->
                new Notification(notification.getType(), notification.getMessage().toUpperCase());
        Function<Notification, Notification> addSuffixModifier = notification ->
                new Notification(notification.getType(), notification.getMessage() + " [MODIFIED]");
        extendedNotificationManager.registerModifier(toUpperCaseModifier);
        extendedNotificationManager.registerModifier(addSuffixModifier);

        Notification testNotification = new Notification("email",
                "Important message about the answer to life, the universe, and everything");
        extendedNotificationManager.sendNotification(testNotification);

        String expectedMessage = "Email notification: IMPORTANT MESSAGE ABOUT THE ANSWER TO LIFE, " +
                "THE UNIVERSE, AND EVERYTHING [MODIFIED]";
        String output = outputStreamCaptor.toString().trim();
        assertEquals(expectedMessage, output);
    }

    @Test
    @DisplayName("Should block notifications with blocked content")
    public void testSendNotificationWithBlockedContent() {
        Predicate<Notification> blockFilter = notification ->
                !notification.getMessage().toLowerCase().contains("urgent");
        extendedNotificationManager.registerFilter(blockFilter);
        Notification notification = new Notification("email", "!!!Urgent action required!!!");
        extendedNotificationManager.sendNotification(notification);

        String expectedMessage = notification.toString() + " - was blocked.";
        String output = outputStreamCaptor.toString().trim();
        assertEquals(expectedMessage, output);
    }
}
