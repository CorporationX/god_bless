package faang.school.godbless.spam;

import java.util.Arrays;
import java.util.List;

public class MessageProcessor {
    private boolean processMessage(String message, List<MessageFilter> filters) {
        for (MessageFilter filter : filters) {
            if (filter.filter(message)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        // �������� ��������
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("����");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("?");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        // ��������� ���������
        String[] messages = {"������!", "��� ����!", "��� ����? ?", "������� ��������� ��� ����� � ������"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("���������: " + message + " | ���������: " + isFiltered);
        }
    }
}


