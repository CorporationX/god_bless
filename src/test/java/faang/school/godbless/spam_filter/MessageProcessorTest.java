package faang.school.godbless.spam_filter;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessageProcessorTest {

    @Test
    void testProcessMessage() {
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("����");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains(":)");
        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        String[] messages = {"������!", "��� ����!", "��� ����? :)", "������� ��������� ��� ����� � ������"};
        List<String> filteredMessages = new ArrayList<>();
        for (String message : messages) {
            boolean isFiltered = MessageProcessor.processMessage(message, filters);
            if (isFiltered) {
                filteredMessages.add(message);
            }
        }

        assertEquals(2, filteredMessages.size());
        assertTrue(filteredMessages.contains("������!"));
        assertFalse(filteredMessages.contains("��� ����!"));
    }
}