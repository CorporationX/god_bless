package school.faang.task_46277;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MessageProcessorTest {
    private final MessageProcessor messageProcessor = new MessageProcessor();

    @Test
    void shouldAcceptFiltersWhenProcessMessage() {
        String str = "Long message without and emoji!";

        boolean isAccepted = messageProcessor.processMessage(str, List.of(message -> message.length() > 10));

        assertTrue(isAccepted);
    }

    @Test
    void shouldNotAcceptFiltersWhenProcessMessage() {
        String str = "Hello!";

        boolean isAccepted = messageProcessor.processMessage(str, List.of(message -> message.length() > 10));

        assertFalse(isAccepted);
    }
}