package faang.school.godbless.FilterSpam;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter filter1 = (message) -> !message.toLowerCase().contains("спам");
        MessageFilter filter2 = (message) -> message.length() > 10;
        MessageFilter filter3 = (message) -> !message.contains("эмодзи");

        List<MessageFilter> filters = Arrays.asList(filter1, filter2, filter3);

        String[] messages = {"Привет!", "Это спам!", "Как дела? эмодзи", "Длинное сообщение без спама и эмодзи"};

        for (String message : messages) {
            boolean result = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + result);
        }

    }
}
