package school.faang.filterspam;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emoFilter = message -> !message.contains("\uD83D\uDE00");
        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emoFilter);
        String[] messages = {"Привет!", "Это спам!", "Как дела? \uD83D\uDE00", "Длинное сообщение без спама и эмодзи", "Some some some"};
        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " Пропущено: " + isFiltered);
        }
    }
}
