package faang.school.godbless.lambda_stream.spam_filter;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessageProcessorTest {

    @Test
    void testProcessMessage() {
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("spam");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains(":)");
        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        String[] messages = {"Hello!", "It's spam!", "How are you? :)", "Long message without emoji"};
        List<String> filteredMessages = new ArrayList<>();
        for (String message : messages) {
            boolean isFiltered = MessageProcessor.processMessage(message, filters);
            if (isFiltered) {
                filteredMessages.add(message);
            }
        }

        assertEquals(1, filteredMessages.size());
        assertTrue(filteredMessages.contains("Long message without emoji"));
        assertFalse(filteredMessages.contains("Hello!"));
    }
}