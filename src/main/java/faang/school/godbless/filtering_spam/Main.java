package faang.school.godbless.filtering_spam;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor processor = new MessageProcessor();

        MessageFilter spamFilter = message -> message.contains("spam");
        MessageFilter lengthFile = message -> message.length() > 14;
        MessageFilter emojiFilter = message -> message.contains("r");

        List<MessageFilter> filters = List.of(spamFilter, lengthFile, emojiFilter);

        String[] messages = {"������", "��� spam!", "��� ����? r", "������� ��������� ��� ����� � ������", "������ �����"};

        for (String message : messages) {
            boolean isFiltered = processor.processorMessage(message, filters);
            System.out.println("���������: " + message + " | ����������: " + isFiltered);
        }
    }
}
