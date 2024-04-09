package faang.school.godbless.lambdas.task_6;

import faang.school.godbless.lambdas.task_6.model.MessageFilter;
import faang.school.godbless.lambdas.task_6.util.MessageProcessor;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();
        MessageFilter spamFilter = message -> !message.contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("😀");
        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);
        String[] messages = {"Привет!", "Это спам", "Как дела? 😀", "Длинное сообщение без спама и эмодзи"};
        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}