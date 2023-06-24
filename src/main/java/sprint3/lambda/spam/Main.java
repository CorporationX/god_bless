package sprint3.lambda.spam;

import java.util.Arrays;
import java.util.List;

public class Main {
    private static final MessageProcessor MESSAGE_PROCESSOR = new MessageProcessor();
    public static void main(String[] args) {
        List<MessageFilter> filters = getMessageFilters();
        List<String> messages = getMessage();

        for (String message : messages) {
            boolean isFiltered = MESSAGE_PROCESSOR.processMessage(message, filters);
            System.out.println("���������: " + message + " | ���������: " + isFiltered);
        }
    }

    private static List<MessageFilter> getMessageFilters() {
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("��� ����������� � ���");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("Azino777");

        return Arrays.asList(spamFilter, lengthFilter, emojiFilter);
    }

    private static List<String> getMessage() {
        return List.of(
                "������ �� xxxyyy.ru � ������ ����� ��� ����������� � ���!",
                "Azino777.com - ����� �����! ������!",
                "���� �����, ���� ��� �����",
                "����."
        );
    }
}
