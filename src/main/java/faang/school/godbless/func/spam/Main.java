package faang.school.godbless.func.spam;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MessageProcessor processor = new MessageProcessor();

        MessageFilter specificWordFilter = message -> !message.toLowerCase().contains("shit");
        MessageFilter emptyMessageFilter = message -> !message.isEmpty();

        List<MessageFilter> filters = Arrays.asList(specificWordFilter, emptyMessageFilter);

        String[] messages = {"Hey!", "", "Ah shit here we go again", "Here we go again"};

        for (String message : messages) {
            boolean isFiltered = processor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}
