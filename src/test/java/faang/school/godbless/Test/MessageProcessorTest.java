package faang.school.godbless.Test;

import faang.school.godbless.MessageFilter;
import faang.school.godbless.MessageProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageProcessorTest {
    MessageProcessor messageProcessor;
    @BeforeEach
    public void setUp() {
        messageProcessor = new MessageProcessor();
    }

    @Test
    public void filterTest() {
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("spam");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("casino");
        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);
        String[] messages = {"Hello!", "This is spam!", "How are you? Play casino free", "Very very long text text text", "Just text ttrtrtr"};
        boolean[] expectedResults = {false, false, false, true, true};
        for (int i = 0; i < messages.length; i++) {
            boolean isFiltered = messageProcessor.processMessage(messages[i], filters);
            assertEquals(expectedResults[i], isFiltered);
        }
    }


}
