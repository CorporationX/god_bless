package faang.school.godbless.task_22_filter_spam;

import faang.school.godbless.sprint_2.functional_interface.task_17_hogwarts.task_22_filter_spam.MessageFilter;
import faang.school.godbless.sprint_2.functional_interface.task_17_hogwarts.task_22_filter_spam.MessageProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MessageProcessorTest {
    private final MessageProcessor messageProcessor = new MessageProcessor();
    private List<MessageFilter> filters;

    @BeforeEach
    void setUp() {
        MessageFilter filter = message -> !message.equals("spam");
        filters = List.of(filter);
    }

    @Test
    public void testProcessMessage_containsSpam() {
        // Arrange
        String message = "spam";

        // Act
        boolean actual = messageProcessor.processMessage(message, filters);

        // Assert
        assertFalse(actual, "сообщение-спам, должно было быть отсеяно");

    }

    @Test
    public void testProcessMessage_noSpam() {
        // Arrange
        String message = "valid message";

        // Act
        boolean actual = messageProcessor.processMessage(message, filters);

        // Assert
        assertTrue(actual, "сообщение валидное, должно было быть пропущено");

    }
}
