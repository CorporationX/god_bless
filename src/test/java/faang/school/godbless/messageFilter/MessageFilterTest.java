package faang.school.godbless.messageFilter;
import faang.school.godbless.sprint2.messageFilter.MessageFilter;
import faang.school.godbless.sprint2.messageFilter.MessageProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MessageFilterTest {
    String[] messages;
    MessageProcessor messageProcessor;
    List<MessageFilter> filters;
    @BeforeEach
    public void init(){
       messageProcessor = new MessageProcessor();
       messages = new String[]{"Hello!", "spam", "\uD83D\uDE00", "A long message without spam and emojis"};

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("spam");
        MessageFilter lengthFilter = message -> message.length() < 10;
        MessageFilter emojiFilter = message -> !message.contains("\uD83D\uDE00");
        filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);
    }

    @Test
    public void messageFilterTest(){
        boolean isFiltered = messageProcessor.processMessage(messages[0], filters);
        boolean isFiltered1 = messageProcessor.processMessage(messages[1], filters);
        boolean isFiltered2 = messageProcessor.processMessage(messages[2], filters);
        boolean isFiltered3 = messageProcessor.processMessage(messages[3], filters);
        assertTrue(isFiltered);
        assertFalse(isFiltered1);
        assertFalse(isFiltered2);
        assertFalse(isFiltered3);
    }

}
