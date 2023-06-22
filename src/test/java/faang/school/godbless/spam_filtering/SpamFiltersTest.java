package faang.school.godbless.spam_filtering;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpamFiltersTest {
    private MessageProcessor messageProcessor;
    private String[] messages;
    private MessageFilter messageAbuseFilter;
    private MessageFilter messageLengthFilter;

    @BeforeEach
    public void setUp() {
        messageProcessor = new MessageProcessor();
        messages = new String[]{"Hello", "Thank", "shit", "a", "bitch"};
        messageAbuseFilter = message -> message.contains("shit") || message.contains("bitch");
        messageLengthFilter = message -> message.length() < 2;
    }

    @Test
    public void testMessageProcessor() {
        assertEquals(false, messageProcessor.processMessage(messages[0], messageAbuseFilter));
        assertEquals(false, messageProcessor.processMessage(messages[1], messageAbuseFilter));
        assertEquals(true, messageProcessor.processMessage(messages[2], messageAbuseFilter));
        assertEquals(true, messageProcessor.processMessage(messages[3], messageLengthFilter));
        assertEquals(false, messageProcessor.processMessage(messages[4], messageLengthFilter));
    }
}
