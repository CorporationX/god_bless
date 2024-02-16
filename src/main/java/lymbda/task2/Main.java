package lymbda.task2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();
        MessageFilter spamFilter = message -> message.toUpperCase().contains("СПАМ");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> message.contains("😀");

        List<MessageFilter> messageFilterList = List.of(spamFilter, lengthFilter, emojiFilter);
        String[] messages = {"Привет!", "Это спам! 😀", "Как дела? 😀", "Длинное сообщение без спама и эмодзи"};
        for (String message : messages) {
            boolean isFilter = messageProcessor.processMessage(message, messageFilterList);
            System.out.println("Coобщение: " + message + " | Пропущено: " + isFilter);
        }
    }
}
