package filtering_spamTest;

import faang.school.godbless.filtering_spam.MessageFilter;
import faang.school.godbless.filtering_spam.MessageProcessor;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MessageProcessorTest {

    @Test
    public void testProcessorMessage() {
        MessageFilter spamFilter = message -> message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> (message.length() > 14);
        MessageFilter emojiFilter = message -> message.contains("?");

        MessageProcessor processor = new MessageProcessor();

        List<MessageFilter> list = List.of(spamFilter, lengthFilter, emojiFilter);

        String messageTrue = "Hello ?";
        String messageFalse = "Hello";

        assertTrue(processor.processorMessage(messageTrue, list));
        assertFalse(processor.processorMessage(messageFalse, list));
    }
}
