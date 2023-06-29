import faang.school.godbless.sprint3.SpamFilter.MessageFilter;
import faang.school.godbless.sprint3.SpamFilter.MessageProcessor;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessageProcessorTest {
    private MessageProcessor messageProcessor = new MessageProcessor();

    @Test
    public void test1() {
        MessageFilter filter = message -> message.length() < 10;
        assertTrue(messageProcessor.processMessage("Hello!", List.of(filter)));
    }

    @Test
    public void test2() {
        MessageFilter filter = message -> message.isEmpty();
        assertTrue(messageProcessor.processMessage("", List.of(filter)));
    }

    @Test
    public void test3() {
        MessageFilter filter1 = message -> message.contains("A");
        MessageFilter filter2 = message -> message.length() == 5;
        assertTrue(messageProcessor.processMessage("A1234", List.of(filter1, filter2)));
    }
}