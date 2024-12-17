package school.faang.task_46326;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessagesFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessagesFilter lengthFilter = message -> message.length() > 10;
        MessagesFilter emojiFilter = message -> !message.contains(":)");


        List<MessagesFilter> filtersList = Arrays.asList(lengthFilter, spamFilter, emojiFilter);

        String[] messages = {"Привет!", "Это спам!", "Как дела? :)", "Длинное сообщение без спама и эмодзи"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMassage(message, filtersList);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}
