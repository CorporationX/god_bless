package faang.school.godbless.sprint3_lambda.spam;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 5;
        MessageFilter spammFilter = message -> !message.contains("spam");

        List<MessageFilter> filters = Arrays.asList(spamFilter,lengthFilter, spammFilter);

        String[] messages = {"Привет!", "Это Жук", "Как дела?", "Длинное сообщение без спама и эмодзи"};

        for (String message : messages) {
            messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + filters);
        }
    }
}
