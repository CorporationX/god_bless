package faang.school.godbless.spamFilter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("spam");
        MessageFilter lengthFilter = message -> message.length() >= 10;
        MessageFilter emojiFilter = message -> !message.contains("\uD83D\uDE00");

        List<MessageFilter> messageFilterList = List.of(spamFilter, lengthFilter, emojiFilter);

        String[] messages = {"Привет!", "Это spam!", "Как дела? \uD83D\uDE00", "Длинное сообщение без spam и эмодзи"};

        for (String message : messages){
            boolean isFiltered = messageProcessor.processMessage(message, messageFilterList);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}
