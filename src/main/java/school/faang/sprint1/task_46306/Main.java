package school.faang.sprint1.task_46306;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("SPAM");
        MessageFilter lenghtFilter = message -> message.length() > 10;
        MessageFilter emotionsFilter = message -> !message.contains("\uD83D\uDE00");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lenghtFilter, emotionsFilter);

        String[] messages = {"Привет", "Это spam", "\uD83D\uDE00",
                "Привет я думаю это длинное сообщение но мне это не важно"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }


    }
}
