package faang.school.godbless.BJS2_10274;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

// �������� ��������
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("����");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("?");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

// ��������� ���������
        String[] messages = {"������!", "��� ����", "��� ����? ?", "������� ��������� ��� ����� � ������"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("���������: " + message + " | ���������: " + isFiltered);
        }
    }
}
